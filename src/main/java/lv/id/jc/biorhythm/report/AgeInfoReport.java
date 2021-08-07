package lv.id.jc.biorhythm.report;

import lv.id.jc.biorhythm.model.ZodiacSign;
import lombok.val;
import lv.id.jc.biorhythm.format.PrettyPeriodFormat;

import java.time.Period;

public class AgeInfoReport extends AbstractReport {
    public AgeInfoReport(Context context) {
        super(context);
    }

    @Override
    public void run() {
        val zodiacSign = ZodiacSign.of(birthday());
        val age = PrettyPeriodFormat.getInstance().format(Period.between(birthday(), date()));

        printf("format.ageInfo", birthday(), zodiacSign, date(), context.getDays(), age);

        if (zodiacSign.getLuckyDay().equals(date().getDayOfWeek())) {
            printf("format.luckyDay", zodiacSign.getLuckyDay(), zodiacSign.name());
        }
    }
}
