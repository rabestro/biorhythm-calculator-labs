package lv.id.jc.biorhythm.model;

import lombok.Getter;

import java.time.temporal.ChronoUnit;

@Getter
public class Indicator {
    private final Context context;
    private final Biorhythm biorhythm;
    private final int dayInPeriod;
    private final Stage stage;
    private final double value;

    Indicator(Biorhythm biorhythm, Context context) {
        this.context = context;
        this.biorhythm = biorhythm;

        int days = (int) ChronoUnit.DAYS.between(context.birthday(), context.date());
        dayInPeriod = days % biorhythm.getPeriod();

        stage = Stage.of(biorhythm.getPeriod(), days);

        value = days < 0 ? Double.NaN
                : Math.sin(2 * Math.PI * days / biorhythm.getPeriod());
    }

    public int getPercent() {
        return (int) Math.round(100 * getValue());
    }

    public int peakInDays() {
        int days = Math.round(biorhythm.getPeriod() / 4.0F - dayInPeriod);
        return days < 0 ? days + biorhythm.getPeriod() : days;
    }

    public int lowInDays() {
        int days = Math.round(3 * biorhythm.getPeriod() / 4.0F - dayInPeriod);
        return days < 0 ? days + biorhythm.getPeriod() : days;
    }

    public int changeInDays() {
        final var halfPeriod = (biorhythm.getPeriod() + 1) / 2;
        return dayInPeriod < halfPeriod
                ? halfPeriod - dayInPeriod % halfPeriod
                : biorhythm.getPeriod() - dayInPeriod;
    }
}
