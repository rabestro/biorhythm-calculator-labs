package reports;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

@Tag("date")
@DisplayName("Test ordinal days")
class AbstractReportTest {

    @ParameterizedTest(name = "{0} = {1}")
    @CsvFileSource(resources = "/day-ordinal.csv", numLinesToSkip = 1)
    void dayOrdinal(final int day, final String expected) {
        assertEquals(expected, AbstractReport.dayOrdinal(day));
    }
}