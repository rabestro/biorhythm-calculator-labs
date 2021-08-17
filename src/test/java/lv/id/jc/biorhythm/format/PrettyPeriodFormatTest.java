package lv.id.jc.biorhythm.format;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.text.Format;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Tag("Formatter")
@DisplayName("Given PrettyPeriodFormat")
class PrettyPeriodFormatTest {
    private Format underTest;

    @BeforeEach
    void setUp() {
        underTest = new PrettyPeriodFormat();
    }

    @Test
    @DisplayName("when parseObject then throws UnsupportedOperationException")
    void parseObject() {
        assertThrows(UnsupportedOperationException.class, () -> underTest.parseObject("1st"));
    }

    @ParameterizedTest(name = "when \"{0}\" then \"{1}\"")
    @CsvFileSource(resources = "/format/pretty-period-format.csv", numLinesToSkip = 1)
    void getAge(final Period period, final String expected) {
        assertEquals(expected, underTest.format(period));
    }


    @Test
    @DisplayName("when unsupported type then throws IllegalArgumentException")
    void IllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> underTest.format("P1D"));
    }

}
