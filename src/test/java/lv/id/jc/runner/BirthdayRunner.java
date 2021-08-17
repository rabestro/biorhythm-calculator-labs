package lv.id.jc.runner;

import lv.id.jc.biorhythm.service.AskBirthday;

public class BirthdayRunner extends AbstractRunner {
    static {
        runner = AskBirthday::new;
    }
}
