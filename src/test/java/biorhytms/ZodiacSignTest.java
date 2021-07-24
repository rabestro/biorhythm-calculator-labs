package biorhytms;

import lombok.val;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ZodiacSignTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/zodiac-sign.csv", numLinesToSkip = 1)
    void matches(LocalDate birthday, ZodiacSign zodiacSign) {
        assertTrue(zodiacSign.matches(birthday));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/zodiac-sign.csv", numLinesToSkip = 1)
    void of(LocalDate birthday, ZodiacSign zodiacSign) {
        val actualSign = ZodiacSign.of(birthday);
        assertEquals(zodiacSign, actualSign);
    }
}