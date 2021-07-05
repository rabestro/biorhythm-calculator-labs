package services;

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
                .printf("%nBirthday: %s", birthday.format(LONG_DATE))
                .printf("%n   Today: %s%n", today.format(LONG_DATE))
                .printf(MessageFormat.format(
                        "%n     Age: {0} years, {1} months and {2} days",
                        period.getYears(), period.getMonths(), period.getDays()))
                .printf("%n    Days: %,d%n", days);
    }
}
