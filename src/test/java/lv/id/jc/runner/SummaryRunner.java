package lv.id.jc.runner;

import lv.id.jc.report.SummaryReport;

public class SummaryRunner extends AbstractRunner {
    static {
        runner = SummaryReport::new;
    }
}
