package lv.id.jc.biorhythm.ui.command;

import lv.id.jc.biorhythm.model.Context;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Given DateMover and date set to 1970-01-01")
class DateMoverTest {
    private static final LocalDate BIRTHDAY = LocalDate.of(1900, 1, 1);

    private Context context;
    private DateMover underTest;

    @BeforeEach
    void setUp() {
        context = new Context(BIRTHDAY, LocalDate.EPOCH);
        underTest = new DateMover(context);
    }

    @ParameterizedTest(name = "when request {0} then date adjusted to {1}")
    @CsvFileSource(resources = "/command/mover-request.csv", numLinesToSkip = 1)
    void adjustMonthDay(final String request, final LocalDate expected) {
        final var result = underTest.apply(request);

        assertTrue(result, "shall recognize and execute request: " + request);
        assertEquals(BIRTHDAY, context.birthday(), "birthday shall be unchanged");
        assertEquals(expected, context.date(), "adjuster shall change the date");
    }

    @ParameterizedTest(name = "when request {0} then returns false")
    @CsvFileSource(resources = "/command/unrecognized.csv", numLinesToSkip = 1)
    void unrecognized(final String request) {
        final var result = underTest.apply(request);

        assertFalse(result, "shall ignore the request: " + request);
        assertEquals(BIRTHDAY, context.birthday(), "birthday shall be unchanged");
        assertEquals(LocalDate.EPOCH, context.date(), "date shall be unchanged");
    }
}