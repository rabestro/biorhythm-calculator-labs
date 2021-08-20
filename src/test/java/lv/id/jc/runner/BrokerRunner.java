package lv.id.jc.runner;

import lv.id.jc.biorhythm.command.*;
import lv.id.jc.biorhythm.report.*;
import lv.id.jc.biorhythm.report.monthly.MonthlyReport;
import lv.id.jc.biorhythm.service.AskBirthday;
import lv.id.jc.biorhythm.service.Broker;

public class BrokerRunner extends AbstractRunner {
    static {
        runner = context -> () -> {
            new AgeInfo(context)
                    .run();
            new ZodiacInfo(context)
                    .run();
            new Broker(context)
                    .add(AskBirthday::new)
                    .add(AgeInfo::new)
                    .add(ZodiacInfo::new)
                    .add(Info::new)
                    .add(DateWith::new)
                    .add(DateAdjuster::new)
                    .add(DateSetter::new)
                    .add(SetDateByName::new)
                    .add(DateMover::new)
                    .add(DailyReport::new)
                    .add(WeeklyReport::new)
                    .add(MonthlyReport::new)
                    .add(AnnualReport::new)
                    .add(SummaryReport::new)
                    .add(TripleChart::new)
                    .run();
        };
    }
}
