package biorhytms;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.LocalDate;
import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ZodiacSign enum should")
class ZodiacSignTest {

    @DisplayName("have exactly twelve signs")
    @Test
    void hasTwelveSigns() {
        val expectedSigns = 12;
        assertEquals(expectedSigns, ZodiacSign.values().length);
    }

    @Nested
    @DisplayName("convert from date to Zodiac Sign")
    class DateConvertedToZodiacSign {

        @ParameterizedTest(name = "{0} is {1}")
        @CsvFileSource(resources = "/monthday-zodiac-sign.csv", numLinesToSkip = 1)
        void monthDayToZodiacSign(final MonthDay date, final ZodiacSign zodiacSign) {
            assertSame(zodiacSign, ZodiacSign.of(date));
        }

        @ParameterizedTest(name = "{0} is {1}")
        @CsvFileSource(resources = "/date-zodiac-sign.csv", numLinesToSkip = 1)
        void localDateToZodiacSign(final LocalDate date, final ZodiacSign zodiacSign) {
            assertSame(zodiacSign, ZodiacSign.of(date));
        }
    }

    @Nested
    @DisplayName("match the date to Zodiac Sign")
    class DateMatchesZodiacSign {

        @ParameterizedTest(name = "{0} matches {1}")
        @CsvFileSource(resources = "/monthday-zodiac-sign.csv", numLinesToSkip = 1)
        void monthDayMatchesZodiacSign(final MonthDay date, final ZodiacSign zodiacSign) {
            assertTrue(zodiacSign.matches(date));
        }

        @ParameterizedTest(name = "{0} matches {1}")
        @CsvFileSource(resources = "/date-zodiac-sign.csv", numLinesToSkip = 1)
        void localDateMatchesZodiacSign(final LocalDate date, final ZodiacSign zodiacSign) {
            assertTrue(zodiacSign.matches(date));
        }
    }

}