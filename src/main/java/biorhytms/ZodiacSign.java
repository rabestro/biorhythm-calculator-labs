package biorhytms;

import lombok.val;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.MonthDay;
import java.util.Arrays;

import static java.time.DayOfWeek.*;
import static java.time.Month.*;

public enum ZodiacSign {
    Aries("The Ram", MonthDay.of(MARCH, 21), MonthDay.of(APRIL, 19), TUESDAY),
    Taurus("The Bull", MonthDay.of(APRIL, 20), MonthDay.of(MAY, 20), FRIDAY),
    Gemini("The Twin", MonthDay.of(MAY, 21), MonthDay.of(JUNE, 20), WEDNESDAY),
    Cancer("The Crab", MonthDay.of(JUNE, 21), MonthDay.of(JULY, 22), SUNDAY),
    Leo("Lion", MonthDay.of(JULY, 23), MonthDay.of(AUGUST, 22), SUNDAY),
    Virgo("The Maiden", MonthDay.of(AUGUST, 23), MonthDay.of(SEPTEMBER, 22), WEDNESDAY),
    Libra("The Scales", MonthDay.of(SEPTEMBER, 23), MonthDay.of(OCTOBER, 22), FRIDAY),
    Scorpio("Scorpion", MonthDay.of(OCTOBER, 23), MonthDay.of(NOVEMBER, 22), TUESDAY),
    Sagittarius("Archer", MonthDay.of(NOVEMBER, 22), MonthDay.of(DECEMBER, 21), THURSDAY),
    Capricorn("The Sea-Goat", MonthDay.of(DECEMBER, 22), MonthDay.of(JANUARY, 19), SATURDAY),
    Aquarius("The Water-Bearer", MonthDay.of(JANUARY, 20), MonthDay.of(FEBRUARY, 18), SATURDAY),
    Pisces("Two Fish", MonthDay.of(FEBRUARY, 19), MonthDay.of(MARCH, 20), SATURDAY);

    private final String symbol;
    private final MonthDay start;
    private final MonthDay end;
    private final DayOfWeek luckyDay;

    ZodiacSign(final String symbol, final MonthDay start, final MonthDay end, final DayOfWeek luckyDay) {
        this.symbol = symbol;
        this.start = start;
        this.end = end;
        this.luckyDay = luckyDay;
    }

    public boolean matches(LocalDate date) {
        val year = date.getYear();
        val one = start.atYear(year);
        val two = end.atYear(year);
        if (this == Capricorn) {
            return date.isEqual(one) || date.isEqual(two) || date.isAfter(one) || date.isBefore(two);
        } else {
            return !(date.isBefore(one) || date.isAfter(two));
        }
    }

    public static ZodiacSign of(LocalDate birthday) {
        return Arrays.stream(values())
                .filter(sign -> sign.matches(birthday))
                .findFirst()
                .orElseThrow();
    }
}
