package services;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Stage1 implements Runnable {
    private final LocalDate birthday;

    public Stage1(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public void run() {

        final var today = LocalDate.now();
        final var days = ChronoUnit.DAYS.between(birthday, today);
        final var period = Period.between(birthday, today);

        System.out.printf("Your birthday is %tA, %<tB %<td %<tY%n", birthday);
        System.out.println("Today is " + today);
        System.out.println("Days spend from your birthday " + days);

        System.out.println(MessageFormat.format(
                "You live {0} years, {1} months and {2} days",
                period.getYears(), period.getMonths(), period.getDays()));
    }
}
