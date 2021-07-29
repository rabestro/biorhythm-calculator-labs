package biorhytms;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.stream.Stream;

public enum Biorhythm {
    Physical(23, "endurance, strength, toughness, coordination"),
    Emotional(28, "mood, sensitivity, creativity"),
    Intellectual(33, "analytical thinking, logic, learning ability, memory"),
    Intuition(38, "unconscious perception, hunches, instincts"),
    Aesthetic(43, "creativity, perception of arts"),
    Awareness(48, "cognition, learning, sense"),
    Spiritual(53, "peace, harmony");

    public static final Value EMPTY = Physical.new Value(-1);
    private final int periodInDays;
    private final String attributes;

    Biorhythm(final int periodDays, final String attributes) {
        this.periodInDays = periodDays;
        this.attributes = attributes.replaceFirst("(.*),", "$1 and");
    }

    public static Stream<Biorhythm> primary() {
        return Stream.of(Physical, Emotional, Intellectual);
    }

    public static Stream<Biorhythm> secondary() {
        return Stream.of(Intuition, Aesthetic, Awareness, Spiritual);
    }

    public String getAttributes() {
        return attributes;
    }

    public int getPeriod() {
        return periodInDays;
    }

    public class Value {
        private final int days;
        private final int rest;
        private final Stage stage;
        private final double value;

        public Value(final LocalDate birthday, final LocalDate date) {
            this(ChronoUnit.DAYS.between(birthday, date));
        }

        public Value(final long days) {
            this.days = (int) days;
            rest = this.days % periodInDays;
            if (rest == 0 || rest * 2 == periodInDays) {
                stage = Stage.ZERO;
            } else {
                stage = Stage.of(1 + rest * 4 / periodInDays);
            }
            value = days < 0
                    ? Double.NaN
                    : Math.sin(2 * Math.PI * days / periodInDays);
        }

        public double getValue() {
            return value;
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
            return String.format("%12s: %4d%% (%2d/%2d) {%d}",
                    name(), getPercent(), rest, periodInDays, stage.ordinal());
        }
    }
}
