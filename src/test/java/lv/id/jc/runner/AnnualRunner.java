package lv.id.jc.runner;

import lv.id.jc.biorhythm.report.AnnualReport;

public class AnnualRunner extends AbstractRunner {
    static {
        runner = AnnualReport::new;
    }
}
