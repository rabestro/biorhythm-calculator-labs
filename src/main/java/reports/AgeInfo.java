package reports;

import biorhytms.ZodiacSign;
import biorhytms.format.PrettyPeriodFormat;

import java.text.Format;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class AgeInfo extends AbstractReport {
    private static final DateTimeFormatter LONG_DATE = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
    private final Format AGE_FORMAT = PrettyPeriodFormat.getInstance();

    public AgeInfo(ReportData reportData) {
        super(reportData);
    }

    @Override
    public void run() {
        println("ageInfo",
                LONG_DATE.format(birthday()),
                ZodiacSign.of(birthday()),
                LONG_DATE.format(date()),
                reportData.getDays(),
                AGE_FORMAT.format(Period.between(birthday(), date()))
        );
    }
}
