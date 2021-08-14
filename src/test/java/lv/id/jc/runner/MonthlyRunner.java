package lv.id.jc.runner;

import lv.id.jc.biorhythm.report.monthly.MonthlyReport;

public class MonthlyRunner extends AbstractRunner {
    static {
        runner = MonthlyReport::new;
    }
}
