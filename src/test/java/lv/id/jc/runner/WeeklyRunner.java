package lv.id.jc.runner;

import lv.id.jc.report.WeeklyReport;

public class WeeklyRunner extends AbstractRunner {
    static {
        reportRunner = WeeklyReport::new;
    }
}
