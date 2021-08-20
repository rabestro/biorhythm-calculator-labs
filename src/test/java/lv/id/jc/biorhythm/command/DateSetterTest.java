package lv.id.jc.biorhythm.command;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Given DateSetter and date 1970-01-01")
class DateSetterTest extends AbstractDateCommand {
    private static final LocalDate BIRTHDAY = LocalDate.of(1900, 1, 1);

    @BeforeEach
    void setUp() {
        super.setUp();
        underTest = new DateSetter(context);
    }

    @ParameterizedTest(name = "when request {0} then date adjusted to {1}")
    @CsvFileSource(resources = "/command/setter-request.csv", numLinesToSkip = 1)
    void recognized(final String request, final LocalDate expected) {
        final var result = underTest.test(request);

        assertTrue(result, "shall recognize and execute request: " + request);
        assertEquals(BIRTHDAY, context.birthday(), "birthday shall be unchanged");
        assertEquals(expected, context.date(), "adjuster shall change the date");
    }

}