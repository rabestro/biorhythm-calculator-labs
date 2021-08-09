package lv.id.jc.biorhythm.report;

import lv.id.jc.biorhythm.Context;
import lv.id.jc.biorhythm.format.PrettyPeriodFormat;
import lv.id.jc.biorhythm.ui.Component;

import java.time.Period;

public class AgeInfoReport extends Component {
    public AgeInfoReport(Context context) {
        super(context);
    }

    @Override
    public void run() {
        final var age = PrettyPeriodFormat.getInstance()
                .format(Period.between(birthday(), date()));

        printf("format.ageInfo", birthday(), date(), context.getDays(), age);
    }
}
