package biorhytms;

import lombok.SneakyThrows;
import lombok.val;

import java.util.Formattable;
import java.util.Formatter;

public class Thermometer implements Formattable {
    private final Biorhythm.Fluctuation fluctuation;

    public Thermometer(final Biorhythm.Fluctuation fluctuation) {
        this.fluctuation = fluctuation;
    }

    @SneakyThrows
    @Override
    public void formatTo(final Formatter formatter, final int flags, final int width, final int precision) {
        formatter.out().append('[');
        val wingWidth = (width - 3) / 2;
        val value = (int) Math.round(wingWidth * fluctuation.getValue());
        if (Stage.ZERO.equals(fluctuation.getStage())) {
            formatter.out()
                    .append("-".repeat(wingWidth))
                    .append(Stage.ZERO.getSymbol())
                    .append("-".repeat(wingWidth));
        } else {
            val symbol = fluctuation.getStage().getSymbol();
            val isPositive = fluctuation.getStage().isPositive();
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
