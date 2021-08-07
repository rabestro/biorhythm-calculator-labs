package lv.id.jc.runner;

import lv.id.jc.biorhythm.report.SummaryReport;

public class SummaryRunner extends AbstractRunner {
    static {
        runner = SummaryReport::new;
    }
}
