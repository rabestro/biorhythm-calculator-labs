package runner;

import report.SummaryReport;

public class SummaryRunner extends AbstractRunner {
    static {
        reportRunner = SummaryReport::new;
    }
}
