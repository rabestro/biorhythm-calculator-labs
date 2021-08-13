package lv.id.jc.biorhythm.model;

import lombok.Getter;

import java.util.Set;

@Getter
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
        if (rest < period / 4) {
            return POSITIVE_UP;
        }
        if (rest < period * 2 / 4) {
            return POSITIVE_DOWN;
        }
        if (rest < period * 3 / 4) {
            return NEGATIVE_DOWN;
        }
        return NEGATIVE_UP;
    }

    @Deprecated(forRemoval = true)
    public static Stage of(final int index) {
        return Stage.values()[index];
    }

    public boolean isUp() {
        return Set.of(POSITIVE_UP, NEGATIVE_UP).contains(this);
    }

    public boolean isPositive() {
        return Set.of(POSITIVE_UP, POSITIVE_DOWN).contains(this);
    }
}
