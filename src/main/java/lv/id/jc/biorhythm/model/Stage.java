package lv.id.jc.biorhythm.model;

import java.util.Set;

public enum Stage {
    ZERO("+"),
    POSITIVE_UP("»"),
    POSITIVE_DOWN("«"),
    NEGATIVE_DOWN("«"),
    NEGATIVE_UP("»");

    private final String symbol;

    Stage(final String symbol) {
        this.symbol = symbol;
    }

    public static Stage of(final int period, final int days) {
        final var rest = days % period;

        if (rest == 0 || rest * 2 == period) {
            return ZERO;
        }

        switch (rest * 4 / period) {
            case 0:
                return POSITIVE_UP;
            case 1:
                return POSITIVE_DOWN;
            case 2:
                return NEGATIVE_DOWN;
            case 3:
                return NEGATIVE_UP;
            default:
                return ZERO;
        }
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isPositive() {
        return Set.of(POSITIVE_UP, POSITIVE_DOWN).contains(this);
    }
}
