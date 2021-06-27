package services;

import java.time.LocalDate;

public abstract class AbstractReport implements Runnable {
    protected final LocalDate birthday;

    public AbstractReport(LocalDate birthday) {
        this.birthday = birthday;
    }

}
