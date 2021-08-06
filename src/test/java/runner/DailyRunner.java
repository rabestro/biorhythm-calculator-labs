package runner;

import lv.id.jc.report.DailyReport;

public class DailyRunner extends AbstractRunner {
    static {
        reportRunner = DailyReport::new;
    }
}
