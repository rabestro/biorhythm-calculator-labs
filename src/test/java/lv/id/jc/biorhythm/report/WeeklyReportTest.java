package lv.id.jc.biorhythm.report;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class WeeklyReportTest extends AbstractReportTest {

    WeeklyReportTest() {
        super(WeeklyReport::new);
    }

    @Test
    void run() {
        underTest.run();

        final var actual = out.toString();

        System.err.println(actual);

        assertTrue(actual.contains("Weekly"));
    }
}