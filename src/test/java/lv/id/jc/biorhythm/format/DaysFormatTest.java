package lv.id.jc.biorhythm.format;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("Formatter")
class DaysFormatTest extends FormatTest {
    static final String CSV = "/days-format.csv";

    @BeforeEach
    void setUp() {
        format = new DaysFormat();
    }

    @ParameterizedTest(name = "{0} = {1}")
    @CsvFileSource(resources = CSV, numLinesToSkip = 1)
    void dayOrdinal(final int day, final String expected) {
        assertEquals(expected, format.format(day));
    }

}