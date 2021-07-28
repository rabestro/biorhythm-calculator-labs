package reports;

import biorhytms.Biorhythm;
import biorhytms.Condition;
import lombok.SneakyThrows;
import lombok.val;

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
