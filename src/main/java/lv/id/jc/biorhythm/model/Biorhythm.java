package lv.id.jc.biorhythm.model;

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

    public static Stream<Biorhythm> stream() {
        return Arrays.stream(values());
    }

    public static Stream<Biorhythm> primary() {
        return Stream.of(PHYSICAL, EMOTIONAL, INTELLECTUAL);
    }

    public static Stream<Biorhythm> secondary() {
        return Stream.of(INTUITION, AESTHETIC, AWARENESS, SPIRITUAL);
    }

    public Indicator getIndicatorOf(Context context) {
        return new Indicator(this, context);
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

}
