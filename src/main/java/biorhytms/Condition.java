package biorhytms;

public enum Condition {
    Well("*"),
    Usually("+"),
    Danger("0"),
    Loose("-"),
    Tired(".");

    private final String symbol;

    Condition(final String symbol) {
        this.symbol = symbol;
    }

    public static Condition of(final double percent) {
        return percent > 90 ? Condition.Well
                : percent > 10 ? Condition.Usually
                : percent > -11 ? Condition.Danger
                : percent > -91 ? Condition.Loose
                : Condition.Tired;
    }

    public String getSymbol() {
        return symbol;
    }
}
