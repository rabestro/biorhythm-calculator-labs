package lv.id.jc.biorhythm.stage;

import lv.id.jc.biorhythm.Context;
import lv.id.jc.biorhythm.command.Info;
import lv.id.jc.biorhythm.command.MoveDate;
import lv.id.jc.biorhythm.report.AgeInfo;
import lv.id.jc.biorhythm.report.DailyReport;
import lv.id.jc.biorhythm.report.ZodiacInfo;
import lv.id.jc.biorhythm.service.AskBirthday;
import lv.id.jc.biorhythm.service.CommandProcessor;
import lv.id.jc.biorhythm.service.Message;

public class Stage3 {
    public static void main(String[] args) {
        // Stage 1
        new Message("welcome");

        var context = new Context();
        new AskBirthday(context).run();
        new AgeInfo(context).run();
        new ZodiacInfo(context).run();

        // Stage 2
        // Daily Report moved to Command Processor

        // Stage 3
        new CommandProcessor(context)
                .add(AskBirthday::new)  // Stage 1
                .add(AgeInfo::new)      // Stage 1
                .add(ZodiacInfo::new)   // Stage 1
                .add(DailyReport::new)  // Stage 2
                .add(Info::new)         // Stage 3
                .add(MoveDate::new)     // Stage 3
                .run();
    }

}
