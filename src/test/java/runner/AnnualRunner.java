package runner;

import lv.id.jc.biorhytm.report.AnnualReport;

public class AnnualRunner extends AbstractRunner {
    static {
        reportRunner = AnnualReport::new;
    }
}
