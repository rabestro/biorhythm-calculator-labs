package lv.id.jc.biorhythm.format;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.text.Format;

import static org.junit.jupiter.api.Assertions.*;

@Tag("Formatter")
@DisplayName("Given OrdinalNumberFormat")
class OrdinalNumberFormatTest {
    private Format underTest;

    @BeforeEach
    void setUp() {
        underTest = new OrdinalNumberFormat();
    }

    @ParameterizedTest(name = "when format {0} then result {1}")
    @CsvFileSource(resources = "/format/ordinal-number-format.csv", numLinesToSkip = 1)
    void dayOrdinal(final int day, final String expected) {
        assertEquals(expected, underTest.format(day));
    }

    @Test
    @DisplayName("when call parseObject then throws UnsupportedOperationException")
    void parseObject() {
        assertThrows(UnsupportedOperationException.class, () -> underTest.parseObject("1st"));
    }


    @Test
    @DisplayName("when unsupported type then throws IllegalArgumentException")
    void IllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> underTest.format("1st"));
    }

}