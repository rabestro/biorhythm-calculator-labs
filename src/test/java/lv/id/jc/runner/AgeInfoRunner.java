package lv.id.jc.runner;

import lv.id.jc.biorhythm.report.AgeInfo;

public class AgeInfoRunner extends AbstractRunner {
    static {
        runner = AgeInfo::new;
    }
}
