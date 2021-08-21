package lv.id.jc.biorhythm.command;

import lv.id.jc.biorhythm.report.Info;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static java.time.LocalDate.EPOCH;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InfoTest extends AbstractDateCommand {
    @BeforeEach
    void setUp() {
        super.setUp();
        underTest = new Info(context);
    }

    @ParameterizedTest(name = "when request {0} then is recognized: {1}")
    @CsvFileSource(resources = "/command/info-request.csv", numLinesToSkip = 1)
    void recognized(final String request) {
        final var result = underTest.test(request);

        assertTrue(result);
        assertEquals(BIRTHDAY, context.birthday(), "birthday shall be unchanged");
        assertEquals(EPOCH, context.date(), "date shall be unchanged");
    }

}