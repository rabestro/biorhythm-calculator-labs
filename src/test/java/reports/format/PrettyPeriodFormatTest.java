package reports.format;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.text.Format;
import java.time.Period;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("Formatter")
@DisplayName("Given PrettyPeriodFormat")
class PrettyPeriodFormatTest {
    private Format formatter;

    @BeforeEach
    void setUp() {
        formatter = new PrettyPeriodFormat();
    }


    @Test
    void parseObject() {
    }

    @ParameterizedTest(name = "when period is \"{0}\" then output is \"{1}\"")
    @CsvFileSource(resources = "/format/pretty-period-format.csv", numLinesToSkip = 1)
    void getAge(final Period period, final String expected) {
        val actual = formatter.format(period);
        assertEquals(expected, actual);
    }

}