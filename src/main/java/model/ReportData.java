package model;

import java.time.LocalDate;

public class ReportData {
    private final LocalDate birthday;
    private LocalDate date;

    public ReportData(final LocalDate birthday) {
        this.birthday = birthday;
        date = LocalDate.now();
    }

    public void setDate(final LocalDate date) {
        this.date = date;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getYear() {
        return date.getYear();
    }
}
