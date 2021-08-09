package lv.id.jc.runner;

import lv.id.jc.biorhythm.report.AgeInfoReport;
import lv.id.jc.biorhythm.report.ZodiacSignReport;

public class AgeZodiacRunner extends AbstractRunner {
    static {
        runner = context -> () -> {
            new AgeInfoReport(context).run();
            new ZodiacSignReport(context).run();
        };
    }
}
