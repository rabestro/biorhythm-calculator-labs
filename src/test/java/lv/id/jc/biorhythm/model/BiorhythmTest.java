package lv.id.jc.biorhythm.model;

import lv.id.jc.biorhythm.model.Biorhythm;
import lv.id.jc.biorhythm.model.Stage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BiorhythmTest {
    private static final double DELTA = 0.01;

    @ParameterizedTest(name = "checks {0}.new Value({1}, {2}) ")
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
        final var underTest = biorhythm.new Value(birthday, date);

        assertAll(
                () -> assertEquals(value, underTest.getValue(), DELTA),
                () -> assertSame(stage, underTest.getStage()),
                () -> assertEquals(change, underTest.changeInDays(), "changeInDays() fails"),
                () -> assertEquals(peak, underTest.peakInDays(), "peakInDays() fails"),
                () -> assertEquals(low, underTest.lowInDays(), "lowInDays() fails")
        );
    }
}