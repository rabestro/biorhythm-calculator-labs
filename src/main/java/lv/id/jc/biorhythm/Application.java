package lv.id.jc.biorhythm;

import lv.id.jc.biorhythm.report.AgeInfo;
import lv.id.jc.biorhythm.report.ZodiacInfo;
import lv.id.jc.biorhythm.service.AskBirthday;
import lv.id.jc.biorhythm.service.DateNavigator;
import lv.id.jc.biorhythm.ui.Component;

public class Application extends Component {
    public Application(final Context context) {
        super(context);
    }

    @Override
    public void run() {
        new AskBirthday(context).run();
        new AgeInfo(context).run();
        new ZodiacInfo(context).run();
        new DateNavigator(context).run();
    }
}
