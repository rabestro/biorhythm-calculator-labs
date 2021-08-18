package lv.id.jc.biorhythm.stage;

import lv.id.jc.biorhythm.model.Context;
import lv.id.jc.biorhythm.report.*;
import lv.id.jc.biorhythm.report.monthly.MonthlyReport;
import lv.id.jc.biorhythm.service.AskBirthday;
import lv.id.jc.biorhythm.service.Broker;
import lv.id.jc.biorhythm.command.DateMover;
import lv.id.jc.biorhythm.command.Info;

public class Stage7 {
    public static void main(String[] args) {
        // Stage 1
        var context = new Context();

        new AskBirthday(context).run();
        new AgeInfo(context).run();
        new ZodiacInfo(context).run();

        // Stage 2
        // Daily Report moved to Command Processor

        // Stage 3
        new Broker(context)
                .add(AskBirthday::new)   // Stage 1
                .add(AgeInfo::new)       // Stage 1
                .add(ZodiacInfo::new)    // Stage 1
                .add(Info::new)          // Stage 3
                .add(DateMover::new)      // Stage 3
                .add(DailyReport::new)   // Stage 2
                .add(WeeklyReport::new)  // Stage 4
                .add(MonthlyReport::new) // Stage 5
                .add(AnnualReport::new)  // Stage 6
                .add(SummaryReport::new) // Stage 7
                .run();
    }

}
