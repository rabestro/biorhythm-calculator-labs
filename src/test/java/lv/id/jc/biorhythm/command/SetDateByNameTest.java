package lv.id.jc.biorhythm.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SetDateByNameTest extends AbstractDateCommand {

    @BeforeEach
    void setUp() {
        super.setUp();
        underTest = new SetDateByName(context);
    }

    @ParameterizedTest(name = "when request {0} then date adjusted to {1}")
    @CsvFileSource(resources = "/command/date-by-name-request.csv", numLinesToSkip = 1)
    void recognized(final String request, final LocalDate expected) {
        final var result = underTest.test(request);

        assertTrue(result, "shall recognize and execute request: " + request);
        assertEquals(BIRTHDAY, context.getBirthday(), "birthday shall be unchanged");
        assertEquals(expected, context.getDate(), "adjuster shall change the date");
    }

    @Test
    @DisplayName("when request `today` then date set to today")
    void testToday() {
        final var result = underTest.test("today");
        assertTrue(result);
        assertEquals(LocalDate.now(), context.getDate());
    }
}