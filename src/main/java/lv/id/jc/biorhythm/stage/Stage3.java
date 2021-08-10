package lv.id.jc.biorhythm.stage;

import lv.id.jc.biorhythm.command.Info;
import lv.id.jc.biorhythm.command.MoveDate;
import lv.id.jc.biorhythm.report.AgeInfoReport;
import lv.id.jc.biorhythm.report.DailyReport;
import lv.id.jc.biorhythm.report.ZodiacSignReport;
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
        new AgeInfoReport(context).run();
        new ZodiacSignReport(context).run();
    }

    @Override
    public void run() {
        welcome();
        new CommandProcessor(context)
                .add(MoveDate::new)
                .add(Info::new)
                .add(AskBirthday::new)
                .add(AgeInfoReport::new)
                .add(ZodiacSignReport::new)
                .add(DailyReport::new)
                .run();
    }

}
