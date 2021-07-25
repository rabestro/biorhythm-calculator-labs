package biorhytms;

import lombok.val;

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
        return stream().filter(Biorhythm::isPrimary);
    }

    public static Stream<Biorhythm> stream() {
        return Arrays.stream(values()).sorted(Comparator.comparing(Biorhythm::getPeriod));
    }

    public boolean isPrimary() {
        return primary;
    }

    public int getPeriod() {
        return periodInDays;
    }

    public class Indicator {
        public final int MAX_VALUE = 20;
        private final long days;
        private final long rest;
        private final long stage;

        private final String scale;
        private final int scaleValue;

        public Indicator(final long days) {
            this.days = days;
            rest = days % periodInDays;
            scaleValue = (int) Math.round(MAX_VALUE * getValue());
            stage = scaleValue == 0 ? 0 : 1 + rest / ((1 + periodInDays) / 4);
            scale = createScale();
        }

        private String createScale() {
            if (stage == 0) {
                return "-".repeat(MAX_VALUE - 1) + "<0>" + "-".repeat(MAX_VALUE - 1);
            }
            val symbol = stage == 1 || stage == 4 ? ">" : "<";
            val isPositive = scaleValue > 0;
            return "-".repeat(isPositive ? MAX_VALUE : MAX_VALUE + scaleValue)
                    + symbol.repeat(isPositive ? 0 : -scaleValue)
                    + "+"
                    + symbol.repeat(isPositive ? scaleValue : 0)
                    + "-".repeat(isPositive ? MAX_VALUE - scaleValue : MAX_VALUE);
        }

        public double getValue() {
            return Math.sin(2 * Math.PI * days / periodInDays);
        }

        public int getPercent() {
            return (int) Math.round(100 * getValue());
        }

        public String getSymbol() {
            return Condition.of(getValue()).getSymbol();
        }

        @Override
        public String toString() {
            return String.format("%12s: %4d%% (%2d/%2d){%d} [%s] [%3d]",
                    name(), getPercent(), rest, periodInDays, stage, scale, scaleValue);
        }
    }
}
