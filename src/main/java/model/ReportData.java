package model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

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
}
