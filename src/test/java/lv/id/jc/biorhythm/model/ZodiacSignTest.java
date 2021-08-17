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
    @CsvFileSource(resources = "/model/zodiac-to-string.csv", numLinesToSkip = 1)
    void testToString(final ZodiacSign zodiacSign, final String expected) {
        assertEquals(expected, zodiacSign.toString());
    }

    @Nested
    @DisplayName("when convert a date to a Zodiac Sign")
    class DateConvertedToZodiacSign {

        @ParameterizedTest(name = "when {0} then sign is {1}")
        @CsvFileSource(resources = "/model/monthday-zodiac-sign.csv", numLinesToSkip = 1)
        void monthDayToZodiacSign(final MonthDay date, final ZodiacSign zodiacSign) {
            assertSame(zodiacSign, ZodiacSign.of(date));
        }

        @ParameterizedTest(name = "when is {0} then sign is {1}")
        @CsvFileSource(resources = "/model/date-zodiac-sign.csv", numLinesToSkip = 1)
        void localDateToZodiacSign(final LocalDate date, final ZodiacSign zodiacSign) {
            assertSame(zodiacSign, ZodiacSign.of(date));
        }
    }

    @Nested
    @DisplayName("when match the date to Zodiac Sign")
    class DateMatchesZodiacSign {

        @ParameterizedTest(name = "then {0} matches {1}")
        @CsvFileSource(resources = "/model/monthday-zodiac-sign.csv", numLinesToSkip = 1)
        void monthDayMatchesZodiacSign(final MonthDay date, final ZodiacSign zodiacSign) {
            assertTrue(zodiacSign.matches(date));
        }

        @ParameterizedTest(name = "then {0} matches {1}")
        @CsvFileSource(resources = "/model/date-zodiac-sign.csv", numLinesToSkip = 1)
        void localDateMatchesZodiacSign(final LocalDate date, final ZodiacSign zodiacSign) {
            assertTrue(zodiacSign.matches(date));
        }
    }

}