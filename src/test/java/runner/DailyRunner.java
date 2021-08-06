package runner;

import lv.id.jc.biorhytm.report.DailyReport;

public class DailyRunner extends AbstractRunner {
    static {
        reportRunner = DailyReport::new;
    }
}
