package lv.id.jc.biorhythm.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DateAdjusterTest extends AbstractDateCommand {

    @BeforeEach
    void setUp() {
        super.setUp();
        underTest = new DateAdjuster(context);
    }

    @ParameterizedTest(name = "when request {0} then date adjusted to {1}")
    @CsvFileSource(resources = "/command/adjuster-request.csv", numLinesToSkip = 1)
    void recognized(final String request, final LocalDate expected) {
        final var result = underTest.apply(request);

        assertTrue(result, "shall recognize and execute request: " + request);
        assertEquals(BIRTHDAY, context.birthday(), "birthday shall be unchanged");
        assertEquals(expected, context.date(), "adjuster shall change the date");
    }

}