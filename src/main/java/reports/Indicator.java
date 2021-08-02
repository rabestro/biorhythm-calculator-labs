package reports;

import biorhytms.Biorhythm;
import biorhytms.Condition;
import lombok.SneakyThrows;
import lombok.val;

import java.text.MessageFormat;
import java.util.Formattable;
import java.util.Formatter;
import java.util.Locale;

import static java.lang.System.Logger.Level.INFO;

public class Indicator implements Formattable {
    public static final Indicator EMPTY = new Indicator();
    private static final System.Logger LOGGER = System.getLogger("");
    private final Biorhythm.Value value;

    private Indicator() {
        value = Biorhythm.EMPTY;
    }

    public Indicator(final Biorhythm.Value value) {
        this.value = value;
    }

    public String getFull() {
        val biorhythm = value.getBiorhythm();
        val sb = new StringBuilder();
        val text = MessageFormat.format(
                value.getStage().getTemplate(),
                biorhythm.name().toLowerCase(),
                biorhythm.getAttributes(),
                value.cycleLastDay().getDayOfWeek(),
                value.cycleLastDay().getMonth(),
                value.cycleLastDay().getDayOfMonth(),
                value.changesInDays()
        );

        sb.append(biorhythm.name()).append(':')
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .append(text.replaceAll("(.{1,60}) ", "$1\n"))
                .append(System.lineSeparator());

        return sb.toString();
    }

    public String splitText(final String text, final int width) {
        return text.replaceAll("(.{1,40}) ", "$#");
    }

    @SneakyThrows
    @Override
    public void formatTo(final Formatter fmt, final int flags, final int width, final int precision) {
        LOGGER.log(INFO, "flags: {0}, width: {1}, precision: {2}", flags, width, precision);

        if (width > -1 && width < 3) {
            fmt.format(Condition.of(value.getValue()).getSymbol());
            return;
        }
        val biorhythm = value.getBiorhythm();

        if (precision == 9) {
            fmt.format("%s:%n%n", biorhythm.name());
            fmt.format(value.getStage().getTemplate(),
                    biorhythm.name().toLowerCase(Locale.ROOT),
                    biorhythm.getAttributes());
            return;
        }
        fmt.format("%12s: %4d%%", biorhythm.name(), value.getPercent());

        if (precision > 0) {
            fmt.format(" (%2d/%2d)", value.getRest(), biorhythm.getPeriod());
        }
    }

    @Override
    public String toString() {
        return String.format("%s", this);
    }
}
