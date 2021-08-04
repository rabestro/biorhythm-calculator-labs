package runner;

import reports.DailyReport;

public class DailyRunner extends AbstractRunner {
    public static void main(String[] args) {
        new DailyReport(getRandomData()).run();
    }
}
