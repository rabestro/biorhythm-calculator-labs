package services;

import biorhytms.Biorhythm;

import java.time.LocalDate;
import java.util.stream.LongStream;

public class TestIndicators implements Runnable {
    private final Biorhythm biorhythm;

    public TestIndicators(final Biorhythm biorhythm) {
        this.biorhythm = biorhythm;
    }

    @Override
    public void run() {
        System.out.println();
        final var birthday = LocalDate.now();
        LongStream.rangeClosed(0, biorhythm.getPeriod() * 2L)
                .mapToObj(days -> biorhythm.new Value(birthday, birthday.plusDays(days)))
                .forEach(System.out::println);
    }
}
