package lv.id.jc.runner;

import lv.id.jc.biorhythm.report.ZodiacInfo;

public class ZodiacSignRunner extends AbstractRunner {
    static {
        runner = ZodiacInfo::new;
    }
}
