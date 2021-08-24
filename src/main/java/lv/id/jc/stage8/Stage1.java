package lv.id.jc.stage8;

import lv.id.jc.biorhythm.model.Context;
import lv.id.jc.biorhythm.report.AgeInfo;
import lv.id.jc.biorhythm.report.ZodiacInfo;
import lv.id.jc.biorhythm.service.AskBirthday;
import lv.id.jc.biorhythm.service.Message;

public class Stage1 {
    public static void main(String[] args) {
        var context = new Context();

        new Message("welcome").run();
        new AskBirthday(context).run();
        new AgeInfo(context).run();
        new ZodiacInfo(context).run();
    }
}
