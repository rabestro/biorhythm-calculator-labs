package lv.id.jc.runner;

import lv.id.jc.biorhythm.report.DailyReport;

public class DailyRunner extends AbstractRunner {
    static {
        runner = DailyReport::new;
    }
}
