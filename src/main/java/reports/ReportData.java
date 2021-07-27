package reports;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Getter
@Setter
public class ReportData {
    private final LocalDate birthday;
    private LocalDate date;

    public ReportData(final LocalDate birthday) {
        this.birthday = birthday;
        date = LocalDate.now();
    }

    public int getYear() {
        return date.getYear();
    }

    public long getDays() {
        return ChronoUnit.DAYS.between(birthday, date);
    }

    public ReportData nextDay() {
        date = date.plusDays(1L);
        return this;
    }
}
