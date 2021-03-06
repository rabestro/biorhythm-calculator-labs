package lv.id.jc.biorhythm.service;

import lv.id.jc.biorhythm.command.AbstractCommand;
import lv.id.jc.biorhythm.model.Context;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class AskBirthday extends AbstractCommand {
    private final LocalDate minimumDate;
    private final LocalDate maximumDate;

    public AskBirthday(final Context context) {
        super(context);
        minimumDate = LocalDate.parse(getString("birthday.minimumDate"));
        maximumDate = LocalDate.now();
    }

    @Override
    public void run() {
        printf("biorhythm.instruction", minimumDate, maximumDate);
        while (true) {
            printf("birthday.prompt");
            try {
                final var date = LocalDate.parse(scanner.nextLine());
                if (date.isAfter(maximumDate)) {
                    printf("birthday.after.today", date, maximumDate);
                } else if (date.isBefore(minimumDate)) {
                    printf("birthday.before.minimum", date, minimumDate);
                } else {
                    context.setBirthday(date);
                    return;
                }
            } catch (DateTimeParseException e) {
                printf("birthday.parse.exception", e.getMessage());
            }
        }
    }
}
