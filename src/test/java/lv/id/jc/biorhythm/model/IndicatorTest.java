package lv.id.jc.biorhythm.model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@Tag("Model")
@DisplayName("Given Indicator and Birthday 1970-01-01")
class IndicatorTest {
    private static final double DELTA = 0.01;

    @ParameterizedTest(name = "when {0}, {1}, {2} then value is {3}, stage is {4} and days are {5}, {6}, {7} ")
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

        final var context = new Context(birthday, date);
        final var underTest = context.getIndicatorOf(biorhythm);

        assertAll(
                () -> assertEquals(value, underTest.value(), DELTA),
                () -> assertSame(stage, underTest.stage()),
                () -> assertEquals(change, underTest.changeInDays(), "changeInDays() fails"),
                () -> assertEquals(peak, underTest.peakInDays(), "peakInDays() fails"),
                () -> assertEquals(low, underTest.lowInDays(), "lowInDays() fails")
        );
    }

    @ParameterizedTest(name = "when {0} and {1} then is {2}%, S {4}, DIP: {3}, CID: {5}")
    @CsvFileSource(resources = "/model/indicator.csv", numLinesToSkip = 1)
    void biorhythmValueTest(
            final Biorhythm biorhythm,
            final LocalDate date,
            final int percent,
            final int dayInPeriod,
            final int stage,
            final int change) {

        final var context = new Context(LocalDate.EPOCH, date);
        final var underTest = context.getIndicatorOf(biorhythm);

        assertAll(
                () -> assertEquals(percent, underTest.percent()),
                () -> assertEquals(dayInPeriod, underTest.dayInPeriod()),
                () -> assertSame(stage, underTest.stage().ordinal(), "incorrect stage"),
                () -> assertEquals(change, underTest.changeInDays(), "changeInDays() fails")
        );
    }

}