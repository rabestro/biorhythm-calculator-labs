package biorhytms;

public enum Condition {
    Well('*'),
    Usually('+'),
    Danger('0'),
    Loose('-'),
    Tired('.');

    private final char symbol;

    Condition(final char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
