package biorhytms;

import static java.lang.Double.isNaN;

public enum Condition {
    Well("*"),
    Usually("+"),
    Danger("0"),
    Loose("-"),
    Tired("."),
    Empty(" ");

    private final String symbol;

    Condition(final String symbol) {
        this.symbol = symbol;
    }

    public static Condition of(final double value) {
        return isNaN(value) ? Empty
                : value > 0.9 ? Well
                : value > 0.1 ? Usually
                : value > -0.1 ? Danger
                : value > -0.9 ? Loose
                : Tired;
    }

    public String getSymbol() {
        return symbol;
    }
}
