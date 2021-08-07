package lv.id.jc.runner;

import lv.id.jc.biorhythm.report.AgeInfoReport;

public class AgeInfoRunner extends AbstractRunner {
    static {
        runner = AgeInfoReport::new;
    }
}
