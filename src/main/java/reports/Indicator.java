package reports;

import biorhytms.Biorhythm;
import biorhytms.Condition;
import lombok.SneakyThrows;
import lombok.val;

import java.util.Formattable;
import java.util.Formatter;

import static java.lang.System.Logger.Level.INFO;

public class Indicator implements Formattable {
    private static final System.Logger LOGGER = System.getLogger("");

    public static final Indicator EMPTY = new Indicator();

    private final Biorhythm.Value value;

    private Indicator() {
        value = Biorhythm.EMPTY;
    }

    public Indicator(final Biorhythm.Value value) {
        this.value = value;
    }

    @SneakyThrows
    @Override
    public void formatTo(final Formatter formatter, final int flags, final int width, final int precision) {
        LOGGER.log(INFO, "flags: {0}, width: {1}, precision: {2}", flags, width, precision);

        if (width > -1 && width < 3) {
            formatter.out().append(Condition.of(value.getValue()).getSymbol());
            return;
        }
        val biorhythm = value.getBiorhythm();
        formatter.out()
                .append(String.format("%12s: %4d%%", biorhythm.name(), value.getPercent()));

        if (precision > 0) {
            formatter.out()
                    .append(String.format(" (%2d/%2d)", value.getRest(), biorhythm.getPeriod()));
        }

    }

    @Override
    public String toString() {
        return value.getBiorhythm().name() + ": " + value.getPercent() + "%";
    }
}
