package reports;

import biorhytms.Biorhythm;
import biorhytms.Stage;
import lombok.SneakyThrows;
import lombok.val;

import java.util.Formattable;
import java.util.Formatter;

public class Thermometer implements Formattable {
    private final Biorhythm.Value value;

    public Thermometer(final Biorhythm.Value value) {
        this.value = value;
    }

    @SneakyThrows
    @Override
    public void formatTo(final Formatter formatter, final int flags, final int width, final int precision) {
        formatter.out().append('[');
        val wingWidth = (width - 3) / 2;
        val value = (int) Math.round(wingWidth * this.value.getValue());
        if (Stage.ZERO.equals(this.value.getStage())) {
            formatter.out()
                    .append("-".repeat(wingWidth))
                    .append(Stage.ZERO.getSymbol())
                    .append("-".repeat(wingWidth));
        } else {
            val symbol = this.value.getStage().getSymbol();
            val isPositive = this.value.getStage().isPositive();
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
