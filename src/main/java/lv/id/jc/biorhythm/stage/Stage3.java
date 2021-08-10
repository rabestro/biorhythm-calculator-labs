package lv.id.jc.biorhythm.stage;

import lv.id.jc.biorhythm.command.Info;
import lv.id.jc.biorhythm.command.MoveDate;
import lv.id.jc.biorhythm.report.AgeInfo;
import lv.id.jc.biorhythm.report.DailyReport;
import lv.id.jc.biorhythm.report.ZodiacInfo;
import lv.id.jc.biorhythm.service.AskBirthday;
import lv.id.jc.biorhythm.service.CommandProcessor;
import lv.id.jc.biorhythm.ui.Component;

public class Stage3 extends Component {
    public static void main(String[] args) {
        new Stage3().run();
    }

    public void welcome() {
        printf("welcome");
        new AskBirthday(context).run();
        new AgeInfo(context).run();
        new ZodiacInfo(context).run();
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
                .run();
    }

}
