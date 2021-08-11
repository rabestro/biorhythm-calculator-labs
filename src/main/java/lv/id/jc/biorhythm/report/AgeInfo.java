package lv.id.jc.biorhythm.report;

import lv.id.jc.biorhythm.Context;
import lv.id.jc.biorhythm.format.PrettyPeriodFormat;
import lv.id.jc.biorhythm.ui.Component;

import java.time.Period;
import java.time.temporal.ChronoUnit;

public class AgeInfo extends Component {
    public AgeInfo(Context context) {
        super(context);
        runnable = () -> printf("format.ageInfo",
                birthday(),
                date(),
                ChronoUnit.DAYS.between(birthday(), date()),
                PrettyPeriodFormat.getInstance().format(Period.between(birthday(), date())));
    }

}
