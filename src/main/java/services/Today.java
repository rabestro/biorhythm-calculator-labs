package services;

import java.time.LocalDate;

public class Today extends AbstractReport {
    public Today(LocalDate birthday) {
        super(birthday);
    }

    @Override
    public void run() {
        final var intellectual = 10.0;

        System.out.printf("Today's Biorhythm Summary:%n")
                .printf("Intellectual: %.2f%%%n", intellectual)
                .printf("   Emotional: %.2f%%%n", intellectual)
                .printf("    Physical: %.2f%%%n", intellectual);
    }
}
