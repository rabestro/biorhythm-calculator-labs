package lv.id.jc.biorhythm.stage;

import lv.id.jc.biorhythm.model.Context;
import lv.id.jc.biorhythm.command.Info;
import lv.id.jc.biorhythm.command.MoveDate;
import lv.id.jc.biorhythm.report.*;
import lv.id.jc.biorhythm.service.AskBirthday;
import lv.id.jc.biorhythm.service.CommandProcessor;

public class Stage5 {
    public static void main(String[] args) {
        // Stage 1
        var context = new Context();

        new AskBirthday(context).run();
        new AgeInfo(context).run();
        new ZodiacInfo(context).run();

        // Stage 2
        // Daily Report moved to Command Processor

        // Stage 3
        new CommandProcessor(context)
                .add(AskBirthday::new)   // Stage 1
                .add(AgeInfo::new)       // Stage 1
                .add(ZodiacInfo::new)    // Stage 1
                .add(Info::new)          // Stage 3
                .add(MoveDate::new)      // Stage 3
                .add(DailyReport::new)   // Stage 2
                .add(WeeklyReport::new)  // Stage 4
                .add(MonthlyReport::new) // Stage 5
                .run();
    }

}
