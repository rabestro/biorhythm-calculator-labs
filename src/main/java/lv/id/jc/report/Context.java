package lv.id.jc.report;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
public class Context {
    private LocalDate birthday;
    private LocalDate date;

    public Context(final LocalDate birthday, final LocalDate date) {
        this.birthday = birthday;
        this.date = date;
    }

    public Context(final LocalDate birthday) {
        this.birthday = birthday;
        date = LocalDate.now();
    }

    public int getYear() {
        return date.getYear();
    }

    public long getDays() {
        return ChronoUnit.DAYS.between(birthday, date);
    }

    public Context nextDay() {
        date = date.plusDays(1L);
        return this;
    }
}
