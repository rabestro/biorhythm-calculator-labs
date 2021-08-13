package lv.id.jc.biorhythm.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@Tag("Model")
@DisplayName("Given Biorhythm enum")
class BiorhythmTest {
    private static final double DELTA = 0.01;

    @ParameterizedTest(name = "when {0} and {1}/{2} then value is {3}, stage is {4} and days are {5}, {6}, {7} ")
    @CsvFileSource(resources = "/biorhythm/biorhythm.csv", numLinesToSkip = 1)
    void biorhythmValueTest(
            final Biorhythm biorhythm,
            final LocalDate birthday,
            final LocalDate date,
            final double value,
            final Stage stage,
            final int change,
            final int peak,
            final int low) {

        final var underTest = biorhythm.new Value(new Context(birthday, date));

        assertAll(
                () -> assertEquals(value, underTest.getValue(), DELTA),
                () -> assertSame(stage, underTest.getStage()),
                () -> assertEquals(change, underTest.changeInDays(), "changeInDays() fails"),
                () -> assertEquals(peak, underTest.peakInDays(), "peakInDays() fails"),
                () -> assertEquals(low, underTest.lowInDays(), "lowInDays() fails")
        );
    }
}