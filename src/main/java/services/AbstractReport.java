package services;

import java.time.LocalDate;

public abstract class AbstractReport implements Runnable {
    private final LocalDate birthday;

    public AbstractReport(LocalDate birthday) {
        this.birthday = birthday;
    }

}
