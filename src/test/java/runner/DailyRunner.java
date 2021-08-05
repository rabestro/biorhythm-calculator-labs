package runner;

import report.DailyReport;

public class DailyRunner extends AbstractRunner {
    static {
        reportRunner = DailyReport::new;
    }
}
