package services;

import lombok.val;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.Period;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgeInfoTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/period-age.csv", delimiter = ';', numLinesToSkip = 1)
    void getAge(final Period period, final String expected) {
        val actual = AgeInfo.getAge(period);
        assertEquals(expected, actual);
    }
}