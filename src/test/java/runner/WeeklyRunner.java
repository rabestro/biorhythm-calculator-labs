package runner;

import reports.WeeklyReport;

public class WeeklyRunner extends AbstractRunner {
    static {
        reportRunner = WeeklyReport::new;
    }
}
