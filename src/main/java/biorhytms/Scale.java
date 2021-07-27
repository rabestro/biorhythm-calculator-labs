package biorhytms;

import lombok.val;

public class Scale {
    private final int maximum;

    public Scale(final int maximum) {
        this.maximum = maximum;
    }

    private String getScale(final Stage stage, final int value) {
        if (stage == Stage.ZERO) {
            return "-".repeat(maximum) + "0" + "-".repeat(maximum);
        }
        val symbol = stage.isUp() ? ">" : "<";
        val isPositive = stage.isPositive();
        return "-".repeat(isPositive ? maximum : maximum + value)
                + symbol.repeat(isPositive ? 0 : -value)
                + "+"
                + symbol.repeat(isPositive ? value : 0)
                + "-".repeat(isPositive ? maximum - value : maximum);

    }

    public String getScale(final Biorhythm.Indicator indicator) {
        val value = (int) Math.round(maximum * indicator.getValue());
        return getScale(indicator.getStage(), value);
    }


}
