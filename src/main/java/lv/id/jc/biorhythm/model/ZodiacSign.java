package lv.id.jc.biorhythm.model;

import lombok.Getter;

import java.time.DayOfWeek;
import java.time.MonthDay;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;
import java.util.Arrays;

import static java.time.DayOfWeek.*;
import static java.time.Month.*;

@Getter
public enum ZodiacSign implements TemporalQuery<Boolean> {
    ARIES("The Ram", MonthDay.of(MARCH, 21), MonthDay.of(APRIL, 19), TUESDAY),
    TAURUS("The Bull", MonthDay.of(APRIL, 20), MonthDay.of(MAY, 20), FRIDAY),
    GEMINI("The Twin", MonthDay.of(MAY, 21), MonthDay.of(JUNE, 20), WEDNESDAY),
    CANCER("The Crab", MonthDay.of(JUNE, 21), MonthDay.of(JULY, 22), SUNDAY),
    LEO("Lion", MonthDay.of(JULY, 23), MonthDay.of(AUGUST, 22), SUNDAY),
    VIRGO("The Maiden", MonthDay.of(AUGUST, 23), MonthDay.of(SEPTEMBER, 22), WEDNESDAY),
    LIBRA("The Scales", MonthDay.of(SEPTEMBER, 23), MonthDay.of(OCTOBER, 22), FRIDAY),
    SCORPIO("Scorpion", MonthDay.of(OCTOBER, 23), MonthDay.of(NOVEMBER, 22), TUESDAY),
    SAGITTARIUS("Archer", MonthDay.of(NOVEMBER, 22), MonthDay.of(DECEMBER, 21), THURSDAY),
    CAPRICORN("The Sea-Goat", MonthDay.of(DECEMBER, 22), MonthDay.of(JANUARY, 19), SATURDAY) {
        @Override
        public Boolean queryFrom(TemporalAccessor temporal) {
            final var monthDay = MonthDay.from(temporal);
            return start.isBefore(monthDay) || end.isAfter(monthDay) || end.equals(monthDay) || start.equals(monthDay);
        }
    },
    AQUARIUS("The Water-Bearer", MonthDay.of(JANUARY, 20), MonthDay.of(FEBRUARY, 18), SATURDAY),
    PISCES("Two Fish", MonthDay.of(FEBRUARY, 19), MonthDay.of(MARCH, 20), SATURDAY);

    protected final MonthDay start;
    protected final MonthDay end;
    private final DayOfWeek luckyDay;
    private final String symbol;

    ZodiacSign(final String symbol, final MonthDay start, final MonthDay end, final DayOfWeek luckyDay) {
        this.symbol = symbol;
        this.start = start;
        this.end = end;
        this.luckyDay = luckyDay;
    }

    public static ZodiacSign from(TemporalAccessor birthday) {
        final var monthDay = MonthDay.from(birthday);
        return Arrays.stream(values())
                .filter(monthDay::query)
                .findFirst()
                .orElseThrow();
    }

    public Boolean queryFrom(TemporalAccessor temporal) {
        final var monthDay = MonthDay.from(temporal);
        return !monthDay.isAfter(end) && !monthDay.isBefore(start);
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
