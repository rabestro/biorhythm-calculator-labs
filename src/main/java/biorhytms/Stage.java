package biorhytms;

import java.util.Set;

public enum Stage {
    ZERO, POSITIVE_UP, POSITIVE_DOWN, NEGATIVE_DOWN, NEGATIVE_UP;

    public boolean isUp() {
        return Set.of(POSITIVE_UP, NEGATIVE_UP).contains(this);
    }

    public boolean isPositive() {
        return Set.of(POSITIVE_UP, POSITIVE_DOWN).contains(this);
    }

    public static Stage of(final int index) {
        return Stage.values()[index];
    }
}
