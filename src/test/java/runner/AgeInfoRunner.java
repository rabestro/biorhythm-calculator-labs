package runner;

import reports.AgeInfoReport;

public class AgeInfoRunner extends AbstractRunner {
    static {
        reportRunner = AgeInfoReport::new;
    }
}
