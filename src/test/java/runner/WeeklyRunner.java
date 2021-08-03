package runner;

import reports.WeeklyReport;

public class WeeklyRunner extends AbstractRunner {
    public static void main(String[] args) {
        new WeeklyReport(getRandomData()).run();
    }

}
