package lv.id.jc.biorhythm.model;

import lombok.Getter;

@Getter
public class Indicator {
    private final Context context;
    private final Biorhythm biorhythm;

    Indicator(Biorhythm biorhythm, Context context) {
        this.context = context;
        this.biorhythm = biorhythm;
    }

    public double value() {
        return context.days() < 0 ? Double.NaN
                : Math.sin(2 * Math.PI * context.days() / biorhythm.period());
    }

    public int percent() {
        return (int) Math.round(100 * this.value());
    }

    public int dayInPeriod() {
        return context.days() % biorhythm.period();
    }

    public Stage stage() {
        return Stage.of(biorhythm.period(), context.days());
    }

    public int peakInDays() {
        int inDays = Math.round(biorhythm.period() / 4.0F - dayInPeriod());
        return inDays < 0 ? inDays + biorhythm.period() : inDays;
    }

    public int lowInDays() {
        int inDays = Math.round(3 * biorhythm.period() / 4.0F - dayInPeriod());
        return inDays < 0 ? inDays + biorhythm.period() : inDays;
    }

    public int changeInDays() {
        final var halfPeriod = (biorhythm.period() + 1) / 2;
        return dayInPeriod() < halfPeriod
                ? halfPeriod - dayInPeriod() % halfPeriod
                : biorhythm.period() - dayInPeriod();
    }
}
