package lv.id.jc.stage8;

import lv.id.jc.biorhythm.command.*;
import lv.id.jc.biorhythm.model.Context;
import lv.id.jc.biorhythm.report.*;
import lv.id.jc.biorhythm.report.fortnight.FortnightReport;
import lv.id.jc.biorhythm.report.monthly.MonthlyReport;
import lv.id.jc.biorhythm.service.AskBirthday;
import lv.id.jc.biorhythm.service.Broker;

public class Stage8 {
    public static void main(String[] args) {
        // Stage 1
        var context = new Context();

        new AskBirthday(context).run();
        new AgeInfo(context).run();
        new ZodiacInfo(context).run();

        new Broker(context)
                .add(AskBirthday::new)      // Stage 1
                .add(AgeInfo::new)          // Stage 1
                .add(ZodiacInfo::new)       // Stage 1
                .add(Info::new)             // Stage 3
                .add(DailyReport::new)      // Stage 2
                .add(WeeklyReport::new)     // Stage 4
                .add(FortnightReport::new)  // Stage 4 @Art1985ss
                .add(MonthlyReport::new)    // Stage 5 @Art1985ss
                .add(AnnualReport::new)     // Stage 6
                .add(SummaryReport::new)    // Stage 7
                .add(TripleChart::new)      // Stage 8
                .add(DateMover::new)        // Stage 3
                .add(SetDateByName::new)    // Stage 3
                .add(DateSetter::new)       // Stage 3
                .add(DateWith::new)
                .add(DateAdjuster::new)
                .add(RomanDateSetter::new)  // Stage 6
                .run();
    }

}
