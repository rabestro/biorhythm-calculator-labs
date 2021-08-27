package lv.id.jc.biorhythm.model;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@AllArgsConstructor
@ToString
public class Context {
    public static final LocalDate MAX_REPORT_DATE = LocalDate.of(2099, 12, 31);
    private LocalDate birthday;
    private LocalDate date;

    public Context() {
        this(LocalDate.MIN);
    }

    public Context(final LocalDate birthday) {
        this.birthday = birthday;
        date = LocalDate.now();
    }

    public Indicator getIndicatorOf(final Biorhythm biorhythm) {
        return new Indicator(biorhythm, this);
    }

    public int getYear() {
        return date.getYear();
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public LocalDate getDate() {
        return date;
    }

    public int days() {
        return (int) ChronoUnit.DAYS.between(birthday, date);
    }

    public Context nextDay() {
        date = date.plusDays(1L);
        return this;
    }

    public Context nextDate() {
        return new Context(birthday, date.plusDays(1L));
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setDate(LocalDate date) throws IllegalContextDate {
        if (date.isBefore(birthday)) {
            throw new IllegalContextDate(
                    "the report date (" + date + ") could not be set before the birthday " + birthday);
        }
        if (date.isAfter(MAX_REPORT_DATE)) {
            throw new IllegalContextDate(
                    "the date " + date + " exceed the maximum report date " + MAX_REPORT_DATE);
        }
        this.date = date;
    }

    public Context withDate(final LocalDate date) {
        return new Context(birthday, date);
    }

    public boolean isValid() {
        return birthday.isAfter(LocalDate.MIN);
    }
}
