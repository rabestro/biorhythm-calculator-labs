package lv.id.jc.runner;

import lv.id.jc.biorhythm.command.Info;
import lv.id.jc.biorhythm.command.MoveDate;
import lv.id.jc.biorhythm.command.SetDate;
import lv.id.jc.biorhythm.report.*;
import lv.id.jc.biorhythm.service.AskBirthday;
import lv.id.jc.biorhythm.service.CommandProcessor;

public class CommandProcessorRunner extends AbstractRunner {
    static {
        runner = context -> () ->
                new CommandProcessor(context)
                        .add(Info::new)
                        .add(SetDate::new)
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
