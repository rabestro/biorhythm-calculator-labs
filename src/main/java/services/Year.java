package services;

import java.time.LocalDate;

public class Year extends AbstractReport {
    private final int year;

    public Year(final LocalDate birthday, final int year) {
        super(birthday);
        this.year = year;
    }

    @Override
    public void run() {

    }
}
