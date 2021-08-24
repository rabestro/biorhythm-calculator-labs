package lv.id.jc.biorhythm.stage8;

import lv.id.jc.biorhythm.command.DateMover;
import lv.id.jc.biorhythm.command.DateSetter;
import lv.id.jc.biorhythm.command.SetDateByName;
import lv.id.jc.biorhythm.model.Context;
import lv.id.jc.biorhythm.report.AgeInfo;
import lv.id.jc.biorhythm.report.DailyReport;
import lv.id.jc.biorhythm.report.Info;
import lv.id.jc.biorhythm.report.ZodiacInfo;
import lv.id.jc.biorhythm.service.AskBirthday;
import lv.id.jc.biorhythm.service.Broker;
import lv.id.jc.biorhythm.service.Message;

public final class Stage3 {
    public static void main(String[] args) {
        // Stage 1
        new Message("welcome");
        final var context = new Context();

        new AskBirthday(context).run();
        new AgeInfo(context).run();
        new ZodiacInfo(context).run();

        // Stage 3
        new Broker(context)
                .add(AskBirthday::new)      // Stage 1
                .add(AgeInfo::new)          // Stage 1
                .add(ZodiacInfo::new)       // Stage 1
                .add(Info::new)             // Stage 3
                .add(DailyReport::new)      // Stage 2
                .add(DateMover::new)        // Stage 3
                .add(SetDateByName::new)    // Stage 3
                .add(DateSetter::new)       // Stage 3
                .run();
    }

}
