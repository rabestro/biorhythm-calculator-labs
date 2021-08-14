package lv.id.jc.biorhythm.model;

import static java.lang.Double.isNaN;

public enum Condition {
    WELL(),
    USUALLY(),
    DANGER(),
    LOOSE(),
    TIRED(),
    EMPTY();

    public static Condition of(final double value) {
        return isNaN(value) ? EMPTY
                : value > 0.95 ? WELL
                : value > 0.05 ? USUALLY
                : value >= -0.05 ? DANGER
                : value >= -0.95 ? LOOSE
                : TIRED;
    }

}
