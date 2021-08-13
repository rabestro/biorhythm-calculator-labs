package lv.id.jc.biorhythm.model;

import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.stream.Stream;

public enum Biorhythm {
    PHYSICAL(23, "endurance, strength, toughness, coordination"),
    EMOTIONAL(28, "mood, sensitivity, creativity"),
    INTELLECTUAL(33, "analytical thinking, logic, learning ability, memory"),
    INTUITION(38, "unconscious perception, hunches, instincts"),
    AESTHETIC(43, "creativity, perception of arts"),
    AWARENESS(48, "cognition, learning, sense"),
    SPIRITUAL(53, "peace, harmony");

    private final int periodInDays;
    private final String attributes;

    Biorhythm(final int periodDays, final String attributes) {
        this.periodInDays = periodDays;
        this.attributes = attributes.replaceFirst("(.*),", "$1 and");
    }

    public Indicator getIndicatorOf(Context context) {
        return new Indicator(this, context);
    }

    public static Stream<Biorhythm> stream() {
        return Arrays.stream(values());
    }
    public static Stream<Biorhythm> primary() {
        return Stream.of(PHYSICAL, EMOTIONAL, INTELLECTUAL);
    }

    public static Stream<Biorhythm> secondary() {
        return Stream.of(INTUITION, AESTHETIC, AWARENESS, SPIRITUAL);
    }

    public String getAttributes() {
        return attributes;
    }

    public int period() {
        return periodInDays;
    }

    /**
     * Returns the name of this enum constant, as contained in the
     * declaration formatted in title case.
     *
     * @return the name of this enum constant in title case
     */
    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toLowerCase();
    }

    /**
     * @deprecated As of release 0.3, replaced by {@link Indicator}
     *
     * The new class Indicator holds all the functionality of this subclass.
     * To create an Indicator use fabric method {@link #getIndicatorOf(Context)}
     *
     */
    @Deprecated(forRemoval = true)
    public class Value {
        private final Context context;
        private final int rest;
        private final Stage stage;
        private final double value;

        public Value(final Context context) {
            this.context = context;
            final int days = (int) ChronoUnit.DAYS.between(context.birthday(), context.date());
            rest = days % periodInDays;
            if (rest == 0 || rest * 2 == periodInDays) {
                stage = Stage.ZERO;
            } else {
                stage = Stage.of(1 + rest * 4 / periodInDays);
            }
            value = days < 0 ? Double.NaN : Math.sin(2 * Math.PI * days / periodInDays);
        }

        public double getValue() {
            return value;
        }


        public int peakInDays() {
            int days = Math.round(periodInDays / 4.0F - rest);
            return days < 0 ? days + periodInDays : days;
        }

        public int lowInDays() {
            int days = Math.round(3 * periodInDays / 4.0F - rest);
            return days < 0 ? days + periodInDays : days;
        }

        public int changeInDays() {
            final var halfPeriod = (periodInDays + 1) / 2;
            return rest < halfPeriod
                    ? halfPeriod - rest % halfPeriod
                    : periodInDays - rest;
        }

        public Stage getStage() {
            return stage;
        }

        public int getPercent() {
            return (int) Math.round(100 * getValue());
        }

        public Biorhythm getBiorhythm() {
            return Biorhythm.this;
        }

        public int getRest() {
            return rest;
        }

        @Override
        public String toString() {
            return String.format("%12s: %s %4d%% (%2d/%2d) {%d}-{%2d} ",
                    name(), context.date(), getPercent(),
                    rest, periodInDays, stage.ordinal(), changeInDays());
        }
    }
}
