package lv.id.jc.biorhythm;

import lv.id.jc.biorhythm.command.*;
import lv.id.jc.biorhythm.model.Context;
import lv.id.jc.biorhythm.report.*;
import lv.id.jc.biorhythm.report.monthly.MonthlyReport;
import lv.id.jc.biorhythm.service.AskBirthday;
import lv.id.jc.biorhythm.service.Broker;
import lv.id.jc.biorhythm.ui.Component;

public class Application extends Component {
    public Application(final Context context) {
        super(context);
    }

    @Override
    public void run() {
        printf("welcome");

        new AskBirthday(context).run();
        new AgeInfo(context).run();
        new ZodiacInfo(context).run();

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
    }
}
