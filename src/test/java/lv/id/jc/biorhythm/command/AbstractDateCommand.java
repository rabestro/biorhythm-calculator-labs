package lv.id.jc.biorhythm.command;

import lv.id.jc.biorhythm.model.Context;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@DisplayName("Given DateCommand and date 1970-01-01")
abstract class AbstractDateCommand {
    static final LocalDate BIRTHDAY = LocalDate.of(1900, 1, 1);

    Context context;
    Command underTest;

    @BeforeEach
    void setUp() {
        context = new Context(BIRTHDAY, LocalDate.EPOCH);
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
