package runner;

import report.AnnualReport;

public class AnnualRunner extends AbstractRunner {
    static {
        reportRunner = AnnualReport::new;
    }
}
