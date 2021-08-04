package runner;

import lombok.val;
import reports.ReportData;

import java.util.Random;

import static java.time.LocalDate.EPOCH;

abstract class AbstractRunner {
    private static final Random random = new Random();
    private static final int MAX_DAYS = 15_000;

    static ReportData getRandomData() {
        val birthday = EPOCH.plusDays(random.nextInt(MAX_DAYS));
        val selected = birthday.plusDays(random.nextInt(MAX_DAYS));
        return new ReportData(birthday, selected);
    }

}
