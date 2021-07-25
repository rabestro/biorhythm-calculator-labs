package services;

import biorhytms.ZodiacSign;
import lombok.val;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class Stage1 implements Runnable {
    private static final DateTimeFormatter LONG_DATE = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);

    private final LocalDate birthday;

    public Stage1(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public void run() {

        final var today = LocalDate.now();
        final var days = ChronoUnit.DAYS.between(birthday, today);
        final var period = Period.between(birthday, today);

        System.out
                .printf("%n%12s: %s (%s)", "Birthday", birthday.format(LONG_DATE), ZodiacSign.of(birthday))
                .printf("%n%12s: %s", "Today", today.format(LONG_DATE))
                .printf("%n%12s: %,d", "Days", days)
                .printf("%n%12s: %s", "Age", getAge(period))
                .println();
    }

    static String getAge(Period period) {
        val years = MessageFormat.format(
                "{0, choice, 0#|1#one year|2#two years|2<{0} years}", period.getYears());
        val months = MessageFormat.format(
                "{0, choice, 0#|1#one month|2#two months|2<{0} months}", period.getMonths());
        val days = MessageFormat.format(
                "{0, choice, 0#|1#one day|2#two days|2<{0} days}", period.getDays());

        if ((years + months + days).isBlank()) {
            return "just born";
        }

        val one = years.isBlank() || (months.isBlank() && days.isBlank())
                ? "" : (months.isBlank() || days.isBlank() ? " and " : ", ");

        val two = days.isBlank() || months.isBlank() ? "" : " and ";

        return years + one + months + two + days;
    }
}
