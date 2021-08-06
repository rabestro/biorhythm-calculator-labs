package lv.id.jc.runner;

import lv.id.jc.report.AnnualReport;

public class AnnualRunner extends AbstractRunner {
    static {
        runner = AnnualReport::new;
    }
}
