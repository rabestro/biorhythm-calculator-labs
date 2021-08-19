package lv.id.jc.biorhythm.format;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.text.Format;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @deprecated in favour to DateFormatterTest
 */
@Deprecated
@Tag("Formatter")
@DisplayName("Given MonthOrdinalDay")
class OrdinalDateFormatTest {
    private Format underTest;

    @BeforeEach
    void setUp() {
        underTest = new OrdinalDateFormat();
    }

    @ParameterizedTest(name = "when {0} then {1}")
    @CsvFileSource(resources = "/format/ordinal-date-format.csv", numLinesToSkip = 1)
    void dayOrdinal(final LocalDate date, final String expected) {
        assertEquals(expected, underTest.format(date));
    }

    @Test
    @DisplayName("when unsupported type then throws IllegalArgumentException")
    void illegal() {
        assertThrows(IllegalArgumentException.class, () -> underTest.format("1st"));
    }

    @Test
    @DisplayName("when parseObject then throws UnsupportedOperationException")
    void parseObject() {
        assertThrows(UnsupportedOperationException.class, () -> underTest.parseObject("1st"));
    }

}