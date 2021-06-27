package biorhytms;

public enum Biorhythms {
    Physical(23),
    Emotional(28),
    Intellectual(33),
    Intuition(38),
    Aesthetic(43),
    Awareness(48),
    Spiritual(53);

    private final int periodDays;

    Biorhythms(final int periodDays) {
        this.periodDays = periodDays;
    }
}
