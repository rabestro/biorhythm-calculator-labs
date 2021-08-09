package lv.id.jc.biorhythm;

import lv.id.jc.biorhythm.report.AgeInfoReport;
import lv.id.jc.biorhythm.report.ZodiacSignReport;
import lv.id.jc.biorhythm.service.BirthdayRequester;
import lv.id.jc.biorhythm.service.DateNavigator;
import lv.id.jc.biorhythm.ui.Component;

public class Application extends Component {
    public Application(final Context context) {
        super(context);
    }

    @Override
    public void run() {
        new BirthdayRequester(context).run();
        new AgeInfoReport(context).run();
        new ZodiacSignReport(context).run();
        new DateNavigator(context).run();
    }
}
