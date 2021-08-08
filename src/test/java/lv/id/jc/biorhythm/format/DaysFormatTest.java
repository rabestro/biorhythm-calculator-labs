package lv.id.jc.biorhythm.format;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.text.Format;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("Formatter")
class DaysFormatTest {
    private Format underTest;

    @BeforeEach
    void setUp() {
        underTest = new DaysFormat();
    }

    @ParameterizedTest(name = "{0} = {1}")
    @CsvFileSource(resources = "/days-format.csv", numLinesToSkip = 1)
    void dayOrdinal(final int day, final String expected) {
        assertEquals(expected, underTest.format(day));
    }
    
}