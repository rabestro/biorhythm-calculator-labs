package runner;

import lv.id.jc.report.AgeInfoReport;

public class AgeInfoRunner extends AbstractRunner {
    static {
        reportRunner = AgeInfoReport::new;
    }
}
