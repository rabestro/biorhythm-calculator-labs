package runner;

import reports.DailyReport;

public class DailyRunner extends AbstractRunner {
    static {
        reportRunner = DailyReport::new;
    }
}
