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

    public boolean isPrimary() {
        return primary;
    }

    public int getPeriod() {
        return periodInDays;
    }

    public double calculate(long days) {
        // sin(2π*cycle length)
        return 100 * Math.sin(2 * Math.PI / periodInDays * days);
    }

    public Condition getCondition(long days) {
        final var value = calculate(days);
        if (value > 90) {
            return Condition.Well;
        }
        if (value > 10) {
            return Condition.Usually;
        }
        if (value > -10) {
            return Condition.Danger;
        }
        if (value > -90) {
            return Condition.Loose;
        }
        return Condition.Tired;
    }

    public static Stream<Biorhythm> primary() {
        return Arrays.stream(values())
                .filter(Biorhythm::isPrimary)
                .sorted(Comparator.comparing(Biorhythm::getPeriod));
    }
}
