package runner;

import lv.id.jc.biorhytm.report.AgeInfoReport;

public class AgeInfoRunner extends AbstractRunner {
    static {
        reportRunner = AgeInfoReport::new;
    }
}
