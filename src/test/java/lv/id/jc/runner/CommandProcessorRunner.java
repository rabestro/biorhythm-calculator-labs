package lv.id.jc.runner;

import lv.id.jc.biorhythm.command.DateMover;
import lv.id.jc.biorhythm.report.Info;
import lv.id.jc.biorhythm.command.SetDateByName;
import lv.id.jc.biorhythm.report.*;
import lv.id.jc.biorhythm.service.AskBirthday;
import lv.id.jc.biorhythm.service.Broker;

public class CommandProcessorRunner extends AbstractRunner {
    static {
        runner = context -> () ->
                new Broker(context)
                        .add(Info::new)
                        .add(SetDateByName::new)
                        .add(DateMover::new)
                        .add(AskBirthday::new)
                        .add(AgeInfo::new)
                        .add(ZodiacInfo::new)
                        .add(DailyReport::new)
                        .add(WeeklyReport::new)
                        .add(AnnualReport::new)
                        .run();
    }
}
