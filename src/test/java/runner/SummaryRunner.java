package runner;

import lv.id.jc.report.SummaryReport;

public class SummaryRunner extends AbstractRunner {
    static {
        reportRunner = SummaryReport::new;
    }
}
