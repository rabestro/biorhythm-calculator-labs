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

    public static Condition of(final double percent) {
        if (percent > 90) {
            return Condition.Well;
        }
        if (percent > 10) {
            return Condition.Usually;
        }
        if (percent > -10) {
            return Condition.Danger;
        }
        if (percent > -90) {
            return Condition.Loose;
        }
        return Condition.Tired;
    }
}
