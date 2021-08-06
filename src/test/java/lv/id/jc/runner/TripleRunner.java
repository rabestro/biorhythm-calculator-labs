package lv.id.jc.runner;

import lv.id.jc.report.TripleChart;

public class TripleRunner extends AbstractRunner {
    static {
        runner = TripleChart::new;
    }
}
