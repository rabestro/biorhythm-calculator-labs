package runner;

import reports.AnnualReport;

public class AnnualRunner extends AbstractRunner {
    public static void main(String[] args) {
        new AnnualReport(getRandomData()).run();
    }
}
