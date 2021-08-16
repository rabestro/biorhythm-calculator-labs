package lv.id.jc.runner;

import lv.id.jc.biorhythm.ui.command.Info;
import lv.id.jc.biorhythm.ui.command.MoveDate;
import lv.id.jc.biorhythm.ui.command.SetDateByName;
import lv.id.jc.biorhythm.report.*;
import lv.id.jc.biorhythm.service.AskBirthday;
import lv.id.jc.biorhythm.service.Broker;

public class CommandProcessorRunner extends AbstractRunner {
    static {
        runner = context -> () ->
                new Broker(context)
                        .add(Info::new)
                        .add(SetDateByName::new)
                        .add(MoveDate::new)
                        .add(AskBirthday::new)
                        .add(AgeInfo::new)
                        .add(ZodiacInfo::new)
                        .add(DailyReport::new)
                        .add(WeeklyReport::new)
                        .add(AnnualReport::new)
                        .run();
    }
}
