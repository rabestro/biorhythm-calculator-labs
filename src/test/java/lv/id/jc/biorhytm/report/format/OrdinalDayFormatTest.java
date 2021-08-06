package lv.id.jc.biorhytm.report.format;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.text.Format;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Tag("Formatter")
@DisplayName("Test ordinal days")
class OrdinalDayFormatTest {

    private Format underTest;

    @BeforeEach
    void setUp() {
        underTest = new OrdinalDayFormat();
    }

    @ParameterizedTest(name = "{0} = {1}")
    @CsvFileSource(resources = "/day-ordinal.csv", numLinesToSkip = 1)
    void dayOrdinal(final int day, final String expected) {
        assertEquals(expected, underTest.format(day));
    }

    @Test
    @DisplayName("throws UnsupportedOperationException on parseObject call")
    void parseObject() {
        assertThrows(UnsupportedOperationException.class, () -> underTest.parseObject("1st"));
    }

}