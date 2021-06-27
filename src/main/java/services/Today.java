package services;

import biorhytms.Biorhythms;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Predicate;

public class Today extends AbstractReport {
    public Today(LocalDate birthday) {
        super(birthday);
    }

    @Override
    public void run() {
        final var today = LocalDate.now();
        final var days = ChronoUnit.DAYS.between(birthday, today);

        final Function<Biorhythms, String> calculate = biorhythm ->
                String.format("%12s: %4.0f%%", biorhythm.name(), biorhythm.calculate(days));

        System.out.println("Today's Biorhythm Summary:");

        System.out.println("\nPrimary Biorhythms\n");
        Arrays.stream(Biorhythms.values())
                .filter(Biorhythms::isPrimary)
                .sorted(Comparator.comparing(Biorhythms::getPeriod))
                .map(calculate)
                .forEach(System.out::println);

        System.out.println("\nSecondary Biorhythms\n");
        Arrays.stream(Biorhythms.values())
                .filter(Predicate.not(Biorhythms::isPrimary))
                .sorted(Comparator.comparing(Biorhythms::getPeriod))
                .map(calculate)
                .forEach(System.out::println);

    }
}
