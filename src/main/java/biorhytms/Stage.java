package biorhytms;

import java.util.Set;

public enum Stage {
    ZERO("0"),
    POSITIVE_UP(">"),
    POSITIVE_DOWN("<"),
    NEGATIVE_DOWN(">"),
    NEGATIVE_UP("<");

    private final String symbol;

    Stage(final String symbol) {
        this.symbol = symbol;
    }

    public static Stage of(final int index) {
        return Stage.values()[index];
    }

    public String getSymbol() {
        return symbol;
    }

    public boolean isUp() {
        return Set.of(POSITIVE_UP, NEGATIVE_UP).contains(this);
    }

    public boolean isPositive() {
        return Set.of(POSITIVE_UP, POSITIVE_DOWN).contains(this);
    }
}
