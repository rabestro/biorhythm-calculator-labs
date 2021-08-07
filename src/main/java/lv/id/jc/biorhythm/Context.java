package lv.id.jc.biorhythm;

import lombok.AllArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Setter
@AllArgsConstructor
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
}
