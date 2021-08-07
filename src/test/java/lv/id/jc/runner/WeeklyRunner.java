package lv.id.jc.runner;

import lv.id.jc.biorhythm.report.WeeklyReport;

public class WeeklyRunner extends AbstractRunner {
    static {
        runner = WeeklyReport::new;
    }
}
