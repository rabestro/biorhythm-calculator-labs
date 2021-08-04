package services;

import biorhytms.ZodiacSign;
import biorhytms.format.PrettyPeriodFormat;
import reports.ReportData;

import java.text.Format;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class AgeInfo implements Runnable {
    private static final DateTimeFormatter LONG_DATE = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
    private final Format AGE = PrettyPeriodFormat.getInstance();

    private final ReportData reportData;

    public AgeInfo(ReportData reportData) {
        this.reportData = reportData;
    }

    @Override
    public void run() {
        final var today = reportData.getDate();
        final var days = ChronoUnit.DAYS.between(reportData.getBirthday(), today);
        final var period = Period.between(reportData.getBirthday(), today);

        System.out
                .printf("%n%12s: %s (%s)", "Birthday",
                        reportData.getBirthday().format(LONG_DATE),
                        ZodiacSign.of(reportData.getBirthday()))
                .printf("%n%12s: %s", "Today", today.format(LONG_DATE))
                .printf("%n%12s: %,d", "Days", days)
                .printf("%n%12s: %s", "Age", AGE.format(period))
                .println();
    }
}
