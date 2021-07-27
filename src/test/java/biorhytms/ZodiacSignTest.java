package biorhytms;

import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Zodiac Signs")
class ZodiacSignTest {

    @ParameterizedTest(name = "{0} matches {1}")
    @CsvFileSource(resources = "/zodiac-sign.csv", numLinesToSkip = 1)
    void matches(final LocalDate birthday, final ZodiacSign zodiacSign) {
        assertTrue(zodiacSign.matches(birthday));
    }

    @ParameterizedTest(name = "{0} is {1}")
    @CsvFileSource(resources = "/zodiac-sign.csv", numLinesToSkip = 1)
    void of(final LocalDate birthday, final ZodiacSign zodiacSign) {
        val actualSign = ZodiacSign.of(birthday);
        assertSame(zodiacSign, actualSign);
    }
}