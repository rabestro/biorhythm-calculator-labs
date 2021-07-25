package biorhytms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public enum Biorhythm {
    Physical(23, true, "endurance, strength, toughness, coordination"),
    Emotional(28, true, "mood, sensitivity, creativity"),
    Intellectual(33, true, "analytical thinking, logic, learning ability, memory"),
    Intuition(38, false, "unconscious perception, hunches, instincts"),
    Aesthetic(43, false, "creativity, perception of arts"),
    Awareness(48, false, "cognition, learning, sense"),
    Spiritual(53, false, "peace, harmony");

    private final int periodInDays;
    private final boolean primary;
    private final String description;

    Biorhythm(final int periodDays, final boolean isPrimary, final String description) {
        this.periodInDays = periodDays;
        this.primary = isPrimary;
        this.description = description;
    }

    public static Stream<Biorhythm> primary() {
        return Arrays.stream(values())
                .filter(Biorhythm::isPrimary)
                .sorted(Comparator.comparing(Biorhythm::getPeriod));
    }

    public boolean isPrimary() {
        return primary;
    }

    public int getPeriod() {
        return periodInDays;
    }

    public class Indicator {
        private final long days;

        public Indicator(final long days) {
            this.days = days;
        }

        public double getValue() {
            return Math.sin(2 * Math.PI / periodInDays * days);
        }

        public int getPercent() {
            return (int) Math.round(100 * getValue());
        }

        public String getSymbol() {
            return Condition.of(getValue()).getSymbol();
        }

        @Override
        public String toString() {
            return String.format("%12s: %4d%%", name(), getPercent());
        }
    }
}
