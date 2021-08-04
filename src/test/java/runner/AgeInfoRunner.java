package runner;

import reports.AgeInfo;

public class AgeInfoRunner extends AbstractRunner {
    public static void main(String[] args) {
        new AgeInfo(getRandomData()).run();
    }
}
