package services;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.Period;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("AgeInfo service")
class AgeInfoTest {

    @ParameterizedTest(name = "{index}: {0} = {1}")
    @CsvFileSource(resources = "/period-age.csv", delimiter = ';', numLinesToSkip = 1)
    void getAge(final Period period, final String expected) {
        assertEquals(expected, AgeInfo.getAge(period));
    }
}