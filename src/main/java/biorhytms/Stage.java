package biorhytms;

import java.util.Set;

public enum Stage {
    ZERO("+",
            "Today is a critical day for your %1$s attributes!%n" +
                    "That means it is an important day to focus on your %2$s.%n"),
    POSITIVE_UP("»",
            "Your are progressing in a positive cycle for your %1$s attributes,%n" +
                    "and this will last until {2}, {3} {4} ({5}).%n" +
                    "Take advantage of your enhanced %2$s!%n"),
    POSITIVE_DOWN("«",
            "Your are in a positive cycle for your %1$s attributes,%n" +
                    "which ends on Wednesday, July 21st (tomorrow).%n" +
                    "Take advantage of your enhanced %2$s while they are at their peak.%n"),
    NEGATIVE_DOWN("«",
            "Your are in a negative cycle for your %1$s attributes,%n" +
                    "which ends on Monday, August 2nd (13 days).%n" +
                    "Your %2$s may not be at their highest,%nso it is a good opportunity to work on them!%n"),
    NEGATIVE_UP("»",
            "Your are in a negative %1$s cycle, but it coming to an end%n" +
                    "on Sunday, July 25th (5 days)!%n" +
                    "Work on improving your %2$s as you near your next positive cycle!%n");

    private final String symbol;
    private final String template;

    Stage(final String symbol, final String template) {
        this.symbol = symbol;
        this.template = template;
    }

    public static Stage of(final int index) {
        return Stage.values()[index];
    }

    public String getSymbol() {
        return symbol;
    }

    public String getTemplate() {
        return template;
    }

    public boolean isUp() {
        return Set.of(POSITIVE_UP, NEGATIVE_UP).contains(this);
    }

    public boolean isPositive() {
        return Set.of(POSITIVE_UP, POSITIVE_DOWN).contains(this);
    }
}
