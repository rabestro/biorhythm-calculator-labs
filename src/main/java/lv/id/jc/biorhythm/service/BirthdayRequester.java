package lv.id.jc.biorhythm.service;

import lv.id.jc.biorhythm.Component;
import lv.id.jc.biorhythm.Context;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class BirthdayRequester extends Component {
    private final LocalDate minimumDate;

    public BirthdayRequester(final Context context) {
        super(context);
        minimumDate = LocalDate.parse(getString("birthday.minimumDate"));
    }

    @Override
    public void run() {
        while (true) {
            printf("birthday.prompt");
            try {
                final var date = LocalDate.parse(scanner.nextLine());
                if (date.isAfter(LocalDate.now())) {
                    printf("birthday.after.today", date, LocalDate.now());
                    continue;
                }
                if (date().isBefore(minimumDate)) {
                    printf("birthday.before.minimum", date, minimumDate);
                    continue;
                }
                context.setBirthday(date);
                return;
            } catch (DateTimeParseException e) {
                printf("birthday.parse.exception", e.getMessage());
            }
        }
    }
}
