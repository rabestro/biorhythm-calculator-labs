package reports;

import biorhytms.ZodiacSign;
import biorhytms.format.PrettyPeriodFormat;

import java.text.Format;
import java.time.Period;

public class AgeInfoReport extends AbstractReport {
    private final Format AGE_FORMAT = PrettyPeriodFormat.getInstance();

    public AgeInfoReport(ReportData reportData) {
        super(reportData);
    }

    @Override
    public void run() {
        printf("format.ageInfo",
                birthday(),
                ZodiacSign.of(birthday()),
                date(),
                reportData.getDays(),
                AGE_FORMAT.format(Period.between(birthday(), date()))
        );
    }
}
