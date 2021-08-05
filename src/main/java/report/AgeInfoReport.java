package report;

import biorhytms.ZodiacSign;
import lombok.val;
import report.format.PrettyPeriodFormat;

import java.time.Period;

public class AgeInfoReport extends AbstractReport {
    public AgeInfoReport(ReportData reportData) {
        super(reportData);
    }

    @Override
    public void run() {
        val zodiacSign = ZodiacSign.of(birthday());
        val age = PrettyPeriodFormat.getInstance().format(Period.between(birthday(), date()));

        printf("format.ageInfo", birthday(), zodiacSign, date(), reportData.getDays(), age);

        if (zodiacSign.getLuckyDay().equals(date().getDayOfWeek())) {
            printf("format.luckyDay", zodiacSign.getLuckyDay(), zodiacSign.name());
        }
    }
}
