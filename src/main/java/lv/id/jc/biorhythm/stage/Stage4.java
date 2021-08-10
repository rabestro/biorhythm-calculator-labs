package lv.id.jc.biorhythm.stage;

import lv.id.jc.biorhythm.command.Info;
import lv.id.jc.biorhythm.command.MoveDate;
import lv.id.jc.biorhythm.report.*;
import lv.id.jc.biorhythm.service.AskBirthday;
import lv.id.jc.biorhythm.service.CommandProcessor;

public class Stage4 extends Stage3 {
    public static void main(String[] args) {
        new Stage4().run();
    }

    @Override
    public void run() {
        welcome();

        new CommandProcessor(context)
                .add(MoveDate::new)
                .add(Info::new)
                .add(AskBirthday::new)
                .add(AgeInfo::new)
                .add(ZodiacInfo::new)
                .add(DailyReport::new)
                .add(WeeklyReport::new)
                .add(AnnualReport::new)
                .run();
    }
}
