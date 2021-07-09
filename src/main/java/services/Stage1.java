package services;

import biorhytms.ZodiacSign;

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
                .printf("%n%12s: %s", "Age", MessageFormat.format("{0} years, {1} months and {2} days",
                        period.getYears(), period.getMonths(), period.getDays()))
                .println();
    }
}
