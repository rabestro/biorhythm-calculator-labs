package services;

import biorhytms.Biorhythm;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Year;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnnualReport extends AbstractReport {
    final String EMPTY = " ".repeat((int) Biorhythm.primary().count());

    private final int year;
    private final boolean isLeap;

    public AnnualReport(final LocalDate birthday, final int year) {
        super(birthday);
        this.year = year;
        isLeap = Year.isLeap(year);
    }

    @Override
    public void run() {
        System.out.println();
        for (int day = 1; day < 32; day++) {
            System.out.printf("%3d ", day);
            for (int month = 1; month < 13; month++) {
                System.out.printf("  %3s", dayConditions(month, day));
            }
            System.out.println();
        }
    }

    private String dayConditions(int month, int day) {
        try {
            final var date = LocalDate.of(year, month, day);
            final var days = ChronoUnit.DAYS.between(birthday, date);

            if (days < 0) {
                return EMPTY;
            }
            Function<Biorhythm, Character> condition = biorhythm -> biorhythm.getCondition(days).getSymbol();

            return Biorhythm.primary()
                    .map(condition)
                    .map(String::valueOf)
                    .collect(Collectors.joining());

        } catch (DateTimeException e) {
            return EMPTY;
        }
    }
}
