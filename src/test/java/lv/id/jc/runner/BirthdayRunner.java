package lv.id.jc.runner;

import lv.id.jc.biorhythm.service.BirthdayRequester;

public class BirthdayRunner extends AbstractRunner{
    static {
        runner = BirthdayRequester::new;
    }
}
