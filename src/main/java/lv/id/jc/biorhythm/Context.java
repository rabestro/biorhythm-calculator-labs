package lv.id.jc.biorhythm;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Setter
@AllArgsConstructor
@ToString
public class Context {
    private LocalDate birthday;
    private LocalDate date;

    public Context(final LocalDate birthday) {
        this.birthday = birthday;
        date = LocalDate.now();
    }

    public int getYear() {
        return date.getYear();
    }

    public LocalDate birthday() {
        return birthday;
    }

    public LocalDate date() {
        return date;
    }

    public long getDays() {
        return ChronoUnit.DAYS.between(birthday, date);
    }

    public Context nextDay() {
        date = date.plusDays(1L);
        return this;
    }

    public Context withDate(final LocalDate date) {
        return new Context(birthday, date);
    }

    public boolean isValid() {
        return birthday.isAfter(LocalDate.MIN);
    }
}
