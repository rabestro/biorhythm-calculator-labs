package lv.id.jc.services;

import java.time.LocalDate;
import java.util.Optional;

public class Params {
    private LocalDate birthday;

    public Optional<LocalDate> getBirthday() {
        return Optional.ofNullable(birthday);
    }

    public void setBirthday(final LocalDate birthday) {
        this.birthday = birthday;
    }

}
