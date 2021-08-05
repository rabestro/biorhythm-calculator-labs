package reports;

import biorhytms.ZodiacSign;
import lombok.val;
import reports.format.PrettyPeriodFormat;

import java.text.Format;
import java.time.Period;

public class AgeInfoReport extends AbstractReport {
    private final Format AGE_FORMAT = PrettyPeriodFormat.getInstance();

    public AgeInfoReport(ReportData reportData) {
        super(reportData);
    }

    @Override
    public void run() {
        val zodiacSign = ZodiacSign.of(birthday());
        printf("format.ageInfo", birthday(), zodiacSign,
                date(),
                reportData.getDays(),
                AGE_FORMAT.format(Period.between(birthday(), date()))
        );

        if (zodiacSign.getLuckyDay().equals(date().getDayOfWeek())) {
            printf("format.luckyDay", zodiacSign.getLuckyDay(), zodiacSign.name());
        }
    }
}
