package runner;

import reports.ReportData;

import java.util.Random;

import static java.time.LocalDate.EPOCH;

abstract class AbstractRunner {
    private static final System.Logger LOGGER = System.getLogger("");
    private static final Random random = new Random();
    private static final int MAX_DAYS = 20_000;

    static ReportData getRandomData() {
        return new ReportData(EPOCH, EPOCH.plusDays(random.nextInt(MAX_DAYS)));
    }


}
