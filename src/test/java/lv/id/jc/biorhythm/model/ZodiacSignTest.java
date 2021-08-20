package lv.id.jc.biorhythm.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.LocalDate;
import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.*;

@Tag("Model")
@DisplayName("Given ZodiacSign enum")
class ZodiacSignTest {

    @DisplayName("then it have exactly twelve constants")
    @Test
    void hasTwelveSigns() {
        final var expectedSigns = 12;
        assertEquals(expectedSigns, ZodiacSign.values().length);
    }

    @ParameterizedTest(name = "when {0} then toString() returns {1}")
    @CsvFileSource(resources = "/model/zodiac-sign-to-string.csv", numLinesToSkip = 1)
    void testToString(final ZodiacSign zodiacSign, final String expected) {
        assertEquals(expected, zodiacSign.toString());
    }

    @ParameterizedTest(name = "given {0} when {1} then isLucky {2}")
    @CsvFileSource(resources = "/model/zodiac-sign-lucky-date.csv", numLinesToSkip = 1)
    void isLuckyDay(final ZodiacSign zodiacSign, final LocalDate date, final boolean expected) {
        assertEquals(expected, date.query(zodiacSign::isLuckyDay));
    }

    @ParameterizedTest(name = "when {0} then {1} - {2}")
    @CsvFileSource(resources = "/model/zodiac-sign-start-end.csv", numLinesToSkip = 1)
    void testToString(final ZodiacSign zodiacSign, final MonthDay start, final MonthDay end) {
        assertEquals(start, zodiacSign.getStart());
        assertEquals(end, zodiacSign.getEnd());
    }

    @Nested
    @DisplayName("when convert a date to a Zodiac Sign")
    class DateConvertedToZodiacSign {

        @ParameterizedTest(name = "when {0} then sign is {1}")
        @CsvFileSource(resources = "/model/zodiac-sign-from-monthday.csv", numLinesToSkip = 1)
        void monthDayToZodiacSign(final MonthDay date, final ZodiacSign zodiacSign) {
            assertSame(zodiacSign, date.query(ZodiacSign::from));
        }

        @ParameterizedTest(name = "when is {0} then sign is {1}")
        @CsvFileSource(resources = "/model/zodiac-sign-from-date.csv", numLinesToSkip = 1)
        void localDateToZodiacSign(final LocalDate date, final ZodiacSign zodiacSign) {
            assertSame(zodiacSign, date.query(ZodiacSign::from));
        }
    }

    @Nested
    @DisplayName("when match the date to Zodiac Sign")
    class DateMatchesZodiacSign {

        @ParameterizedTest(name = "then {0} matches {1}")
        @CsvFileSource(resources = "/model/zodiac-sign-from-monthday.csv", numLinesToSkip = 1)
        void monthDayMatchesZodiacSign(final MonthDay date, final ZodiacSign zodiacSign) {
            assertTrue(date.query(zodiacSign));
        }

        @ParameterizedTest(name = "then {0} matches {1}")
        @CsvFileSource(resources = "/model/zodiac-sign-from-date.csv", numLinesToSkip = 1)
        void localDateMatchesZodiacSign(final LocalDate date, final ZodiacSign zodiacSign) {
            assertTrue(date.query(zodiacSign));
        }
    }

}