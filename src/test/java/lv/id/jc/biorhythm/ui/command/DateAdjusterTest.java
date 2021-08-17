package lv.id.jc.biorhythm.ui.command;

import lv.id.jc.biorhythm.model.Context;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Given DateAdjuster and Epoch (1970-01-01) date")
class DateAdjusterTest {
    private static final LocalDate BIRTHDAY = LocalDate.of(1900, 1, 1);

    private Context context;
    private DateAdjuster underTest;

    @BeforeEach
    void setUp() {
        context = new Context(BIRTHDAY, LocalDate.EPOCH);
        underTest = new DateAdjuster(context);
    }

    @ParameterizedTest(name = "when request {0} then date adjusted to {1}")
    @CsvFileSource(resources = "/command/adjuster-request.csv", numLinesToSkip = 1)
    void adjustMonthDay(final String request, final LocalDate expected) {
        final var result = underTest.apply(request);

        assertTrue(result, "shall recognize and execute request: " + request);
        assertEquals(BIRTHDAY, context.birthday(), "birthday shall be unchanged");
        assertEquals(expected, context.date(), "adjuster shall change the date");
    }

}