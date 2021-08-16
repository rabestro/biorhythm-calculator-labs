package lv.id.jc.biorhythm.format;

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
@DisplayName("Given RomanFormat")
class RomanFormatTest {

    private Format underTest;

    @BeforeEach
    void setUp() {
        underTest = new RomanFormat();
    }

    @Test
    @DisplayName("when parseObject then throws UnsupportedOperationException")
    void parseObject() {
        assertThrows(UnsupportedOperationException.class, () -> underTest.parseObject("IV"));
    }

    @ParameterizedTest(name = "when \"{0}\" then \"{1}\"")
    @CsvFileSource(resources = "/format/arabic-roman-format.csv", numLinesToSkip = 1, delimiter = '=')
    void getAge(final Integer number, final String expected) {
        assertEquals(expected, underTest.format(number));
    }

}