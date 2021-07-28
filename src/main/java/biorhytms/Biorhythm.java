package biorhytms;

import java.util.stream.Stream;

public enum Biorhythm {
    Physical(23, "endurance, strength, toughness, coordination"),
    Emotional(28, "mood, sensitivity, creativity"),
    Intellectual(33, "analytical thinking, logic, learning ability, memory"),
    Intuition(38, "unconscious perception, hunches, instincts"),
    Aesthetic(43, "creativity, perception of arts"),
    Awareness(48, "cognition, learning, sense"),
    Spiritual(53, "peace, harmony");

    private final int periodInDays;
    private final String description;

    Biorhythm(final int periodDays, final String description) {
        this.periodInDays = periodDays;
        this.description = description;
    }

    public static Stream<Biorhythm> primary() {
        return Stream.of(Physical, Emotional, Intellectual);
    }

    public static Stream<Biorhythm> secondary() {
        return Stream.of(Intuition, Aesthetic, Awareness, Spiritual);
    }

    public int getPeriod() {
        return periodInDays;
    }

    public class Value {
        private final long days;
        private final long rest;
        private final Stage stage;

        public Value(final long days) {
            this.days = days;
            rest = days % periodInDays;

            if (rest == 0 || rest * 2 == periodInDays) {
                stage = Stage.ZERO;
            } else {
                stage = Stage.of((int) (1 + rest * 4 / periodInDays));

            }
        }

        public double getValue() {
            return Math.sin(2 * Math.PI * days / periodInDays);
        }

        public Stage getStage() {
            return stage;
        }

        public int getPercent() {
            return (int) Math.round(100 * getValue());
        }

        public String getSymbol() {
            return Condition.of(getPercent()).getSymbol();
        }

        @Override
        public String toString() {
            return String.format("%12s: %4d%% (%2d/%2d) {%d}",
                    name(), getPercent(), rest, periodInDays, stage.ordinal());
        }
    }
}
