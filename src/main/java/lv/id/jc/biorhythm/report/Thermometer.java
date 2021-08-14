package lv.id.jc.biorhythm.report;

import lombok.SneakyThrows;
import lombok.val;
import lv.id.jc.biorhythm.model.Indicator;
import lv.id.jc.biorhythm.model.Stage;

import java.util.Formattable;
import java.util.Formatter;

public class Thermometer implements Formattable {
    private final Indicator indicator;

    public Thermometer(final Indicator indicator) {
        this.indicator = indicator;
    }

    @SneakyThrows
    @Override
    public void formatTo(final Formatter formatter, final int flags, final int width, final int precision) {
        formatter.out().append('[');
        val wingWidth = (width - 3) / 2;
        val value = (int) Math.round(wingWidth * indicator.value());
        if (Stage.ZERO.equals(this.indicator.stage())) {
            formatter.out()
                    .append("-".repeat(wingWidth))
                    .append(Stage.ZERO.getSymbol())
                    .append("-".repeat(wingWidth));
        } else {
            val symbol = indicator.stage().getSymbol();
            val isPositive = indicator.stage().isPositive();
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
