package services;

import biorhytms.Biorhythm;

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

        final Function<Biorhythm, String> calculate = biorhythm ->
                String.format("%12s: %4.0f%%", biorhythm.name(), biorhythm.calculate(days));

        System.out.println("Today's Biorhythm Summary:");

        System.out.println("\nPrimary Biorhythms\n");
        Arrays.stream(Biorhythm.values())
                .filter(Biorhythm::isPrimary)
                .sorted(Comparator.comparing(Biorhythm::getPeriod))
                .map(calculate)
                .forEach(System.out::println);

        System.out.println("\nSecondary Biorhythms\n");
        Arrays.stream(Biorhythm.values())
                .filter(Predicate.not(Biorhythm::isPrimary))
                .sorted(Comparator.comparing(Biorhythm::getPeriod))
                .map(calculate)
                .forEach(System.out::println);

    }
}
