package runner;

import reports.AgeInfoReport;

public class AgeInfoRunner extends AbstractRunner {
    public static void main(String[] args) {
        new AgeInfoReport(getRandomData()).run();
    }
}
