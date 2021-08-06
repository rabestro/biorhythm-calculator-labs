package runner;

import lv.id.jc.report.AnnualReport;

public class AnnualRunner extends AbstractRunner {
    static {
        reportRunner = AnnualReport::new;
    }
}
