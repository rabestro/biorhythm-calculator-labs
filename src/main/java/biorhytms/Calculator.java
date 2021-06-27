package biorhytms;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Calculator {
    private final LocalDate birthday;

    public Calculator(final LocalDate birthday) {
        this.birthday = birthday;
    }

    public Result calculate(final LocalDate date) {
        final var days = ChronoUnit.DAYS.between(birthday, date);
        final var period = Period.between(birthday, date);
//        return new Result(birthday, date, days, period, intellectual, physical, emotional);
        return null;
    }

}
