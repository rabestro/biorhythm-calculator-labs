package lv.id.jc.biorhythm.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("Model")
@DisplayName("Given Biorhythm enum")
class BiorhythmTest {

    @Test
    @DisplayName("when values() then it returns seven constants")
    void hasTwelveSigns() {
        final var expectedSigns = 7;
        assertEquals(expectedSigns, Biorhythm.values().length);
    }

    @ParameterizedTest(name = "when {0} then toString() returns {1}")
    @CsvFileSource(resources = "/model/biorhythm-to-string.csv", numLinesToSkip = 1)
    void testToString(final Biorhythm biorhythm, final String expected) {
        assertEquals(expected, biorhythm.toString());
    }

    @ParameterizedTest(name = "when {0} then period() returns {1}")
    @CsvFileSource(resources = "/model/biorhythm-period.csv", numLinesToSkip = 1)
    void period(final Biorhythm biorhythm, final int expected) {
        assertEquals(expected, biorhythm.period());
    }
}