package lv.id.jc.biorhytm;

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
