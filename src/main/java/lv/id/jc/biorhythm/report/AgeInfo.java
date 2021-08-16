package lv.id.jc.biorhythm.report;

import lv.id.jc.biorhythm.format.PrettyPeriodFormat;
import lv.id.jc.biorhythm.model.Context;
import lv.id.jc.biorhythm.ui.command.AbstractCommand;

import java.time.Period;
import java.time.temporal.ChronoUnit;

public class AgeInfo extends AbstractCommand {
    public AgeInfo(Context context) {
        super(context);
    }

    @Override
    public void run() {
        printf("format.ageInfo",
                birthday(),
                date(),
                ChronoUnit.DAYS.between(birthday(), date()),
                PrettyPeriodFormat.getInstance().format(Period.between(birthday(), date())));
    }
}
