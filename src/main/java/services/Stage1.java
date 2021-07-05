package services;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

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

//        Locale.setDefault(Locale.FRANCE);
        final var formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);

        System.out.println("Your birthday is " + birthday.format(formatter));
        System.out.println("Today is " + today.format(LONG_DATE));

        System.out.println(MessageFormat.format(
                "You are {0} years, {1} months and {2} days old",
                period.getYears(), period.getMonths(), period.getDays()));

        System.out.println("You are lived for " + days + " days");
    }
}
