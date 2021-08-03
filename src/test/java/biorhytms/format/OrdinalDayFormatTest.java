package biorhytms.format;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.text.Format;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test ordinal days")
class OrdinalDayFormatTest {

    private Format ordinalDayFormat;

    @BeforeEach
    void setUp() {
        ordinalDayFormat = new OrdinalDayFormat();
    }

    @ParameterizedTest(name = "{0} = {1}")
    @CsvFileSource(resources = "/day-ordinal.csv", numLinesToSkip = 1)
    void dayOrdinal(final int day, final String expected) {
        assertEquals(expected, ordinalDayFormat.format(day));
    }
}