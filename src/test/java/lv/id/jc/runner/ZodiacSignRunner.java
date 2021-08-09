package lv.id.jc.runner;

import lv.id.jc.biorhythm.report.ZodiacSignReport;

public class ZodiacSignRunner extends AbstractRunner {
    static {
        runner = ZodiacSignReport::new;
    }
}
