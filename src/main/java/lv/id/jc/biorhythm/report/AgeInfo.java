package lv.id.jc.biorhythm.report;

import lv.id.jc.biorhythm.command.AbstractCommand;
import lv.id.jc.biorhythm.format.PrettyPeriodFormat;
import lv.id.jc.biorhythm.model.Context;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class AgeInfo extends AbstractCommand {
    public AgeInfo(Context context) {
        super(context);
    }

    @Override
    public void run() {
        final var format = date().equals(LocalDate.now()) ? "ageInfo.today" : "ageInfo.report";
        printf(format, birthday(), date(),
                ChronoUnit.DAYS.between(birthday(), date()),
                PrettyPeriodFormat.getInstance().format(Period.between(birthday(), date())));
    }
}
