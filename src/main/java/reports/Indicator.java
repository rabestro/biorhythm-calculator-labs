package reports;

import biorhytms.Biorhythm;
import biorhytms.Condition;
import lombok.SneakyThrows;

import java.util.Formattable;
import java.util.Formatter;

public class Indicator implements Formattable {
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
        if (width < 3) {
            formatter.out().append(Condition.of(value.getValue()).getSymbol());
            return;
        }

    }

}
