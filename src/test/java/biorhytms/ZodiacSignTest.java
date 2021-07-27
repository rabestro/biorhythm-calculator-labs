package biorhytms;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.LocalDate;
import java.time.MonthDay;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("ZodiacSign enum should")
class ZodiacSignTest {
    @Nested
    @DisplayName("convert from date to Zodiac Sign")
    class Conversion {
        @ParameterizedTest(name = "{0} is {1}")
        @CsvFileSource(resources = "/monthday-zodiac-sign.csv", numLinesToSkip = 1)
        void fromMonthDay2ZodiacSign(final MonthDay date, final ZodiacSign zodiacSign) {
            assertSame(zodiacSign, ZodiacSign.of(date));
        }

        @ParameterizedTest(name = "{0} is {1}")
        @CsvFileSource(resources = "/date-zodiac-sign.csv", numLinesToSkip = 1)
        void of(final LocalDate birthday, final ZodiacSign zodiacSign) {
            val actualSign = ZodiacSign.of(birthday);
            assertSame(zodiacSign, actualSign);
        }

    }

    @Nested
    @DisplayName("match the date to Zodiac Sign")
    class DateMatchesZodiacSign {

        @ParameterizedTest(name = "{0} matches {1}")
        @CsvFileSource(resources = "/date-zodiac-sign.csv", numLinesToSkip = 1)
        void matches(final LocalDate birthday, final ZodiacSign zodiacSign) {
            assertTrue(zodiacSign.matches(birthday));
        }
    }


}