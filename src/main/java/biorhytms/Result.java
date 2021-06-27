package biorhytms;

import java.time.LocalDate;
import java.time.Period;

public class Result {
    private final LocalDate birthday;
    private final LocalDate date;
    private final int days;
    private final Period period;
    private final double intellectual;
    private final double physical;
    private final double emotional;

    public Result(
            final LocalDate birthday,
            final LocalDate date,
            final int days,
            final Period period,
            final double intellectual,
            final double physical,
            final double emotional) {
        this.birthday = birthday;
        this.date = date;
        this.days = days;
        this.period = period;
        this.intellectual = intellectual;
        this.physical = physical;
        this.emotional = emotional;
    }
}
