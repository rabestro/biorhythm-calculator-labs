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

    public String getSymbol() {
        return symbol;
    }
}
