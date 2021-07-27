package biorhytms;

import lombok.SneakyThrows;
import lombok.val;

import java.util.Formattable;
import java.util.Formatter;

public class Thermometer implements Formattable {
    private final Biorhythm.Indicator indicator;

    public Thermometer(final Biorhythm.Indicator indicator) {
        this.indicator = indicator;
    }

    @SneakyThrows
    @Override
    public void formatTo(final Formatter formatter, final int flags, final int width, final int precision) {
        formatter.out().append('[');
        val wingWidth = (width - 3) / 2;
        val value = (int) Math.round(wingWidth * indicator.getValue());
        if (indicator.getStage().equals(Stage.ZERO)) {
            formatter.out()
                    .append("-".repeat(wingWidth))
                    .append('0')
                    .append("-".repeat(wingWidth));
        } else {
            val symbol = indicator.getStage().isUp() ? ">" : "<";
            val isPositive = indicator.getStage().isPositive();
            formatter.out()
                    .append("-".repeat(isPositive ? wingWidth : wingWidth + value))
                    .append(symbol.repeat(isPositive ? 0 : -value))
                    .append('+')
                    .append(symbol.repeat(isPositive ? value : 0))
                    .append("-".repeat(isPositive ? wingWidth - value : wingWidth));
        }
        formatter.out().append(']');
    }
}
