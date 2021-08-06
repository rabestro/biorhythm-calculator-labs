package runner;

import lv.id.jc.biorhytm.report.SummaryReport;

public class SummaryRunner extends AbstractRunner {
    static {
        reportRunner = SummaryReport::new;
    }
}
