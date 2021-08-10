package lv.id.jc.runner;

import lv.id.jc.biorhythm.report.AgeInfo;
import lv.id.jc.biorhythm.report.ZodiacInfo;

public class AgeZodiacRunner extends AbstractRunner {
    static {
        runner = context -> () -> {
            new AgeInfo(context).run();
            new ZodiacInfo(context).run();
        };
    }
}
