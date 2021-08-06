package lv.id.jc.biorhytm;

import static java.lang.Double.isNaN;

public enum Condition {
    Well(),
    Usually(),
    Danger(),
    Loose(),
    Tired(),
    Empty();

    public static Condition of(final double value) {
        return isNaN(value) ? Empty
                : value > 0.9 ? Well
                : value > 0.05 ? Usually
                : value > -0.05 ? Danger
                : value > -0.9 ? Loose
                : Tired;
    }

}
