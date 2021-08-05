package runner;

import report.AgeInfoReport;

public class AgeInfoRunner extends AbstractRunner {
    static {
        reportRunner = AgeInfoReport::new;
    }
}
