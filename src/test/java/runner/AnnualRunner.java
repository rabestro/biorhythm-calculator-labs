package runner;

import reports.AnnualReport;

public class AnnualRunner extends AbstractRunner {
    static {
        reportRunner = AnnualReport::new;
    }
}
