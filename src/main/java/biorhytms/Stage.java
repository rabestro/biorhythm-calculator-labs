package biorhytms;

import java.util.Set;

public enum Stage {
    ZERO("+",
            "Today is a critical day for your {0} attributes! " +
                    "That means it is an important day to focus on your {1}."),
    POSITIVE_UP("»",
            "Your are progressing in a positive cycle for your {0} attributes, " +
                    "and this will last until {2}, {3} {4} ({5}). " +
                    "Take advantage of your enhanced {1}!"),
    POSITIVE_DOWN("«",
            "Your are in a positive cycle for your {0} attributes, " +
                    "which ends on Wednesday, July 21st (tomorrow). " +
                    "Take advantage of your enhanced {1} while they are at their peak."),
    NEGATIVE_DOWN("«",
            "Your are in a negative cycle for your {0} attributes, " +
                    "which ends on Monday, August 2nd (13 days). " +
                    "Your {1} may not be at their highest, so it is a good opportunity to work on them!"),
    NEGATIVE_UP("»",
            "Your are in a negative {0} cycle, but it coming to an end " +
                    "on Sunday, July 25th (5 days)! " +
                    "Work on improving your {1} as you near your next positive cycle!");

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

    public boolean isUp() {
        return Set.of(POSITIVE_UP, NEGATIVE_UP).contains(this);
    }

    public boolean isPositive() {
        return Set.of(POSITIVE_UP, POSITIVE_DOWN).contains(this);
    }
}
