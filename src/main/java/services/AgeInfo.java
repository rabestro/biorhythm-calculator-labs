package services;

import biorhytms.ZodiacSign;
import lombok.val;
import reports.ReportData;

import java.text.MessageFormat;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class AgeInfo implements Runnable {
    private static final DateTimeFormatter LONG_DATE = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);

    private final ReportData reportData;

    public AgeInfo(ReportData reportData) {
        this.reportData = reportData;
    }

    static String getAge(Period period) {
        val years = MessageFormat.format(
                "{0, choice, 0#|1#one year|2#two years|2<{0} years}", period.getYears());
        val months = MessageFormat.format(
                "{0, choice, 0#|1#one month|2#two months|2<{0} months}", period.getMonths());
        val days = MessageFormat.format(
                "{0, choice, 0#|1#one day|2#two days|2<{0} days}", period.getDays());

        if ((years + months + days).isEmpty()) {
            return "just born";
        }

        val one = years.isEmpty() || (months.isEmpty() && days.isEmpty())
                ? "" : months.isEmpty() || days.isEmpty() ? " and " : ", ";

        val two = days.isEmpty() || months.isEmpty() ? "" : " and ";

        return years + one + months + two + days;
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
                .printf("%n%12s: %s", "Age", getAge(period))
                .println();
    }
}
