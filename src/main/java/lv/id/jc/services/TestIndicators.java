package lv.id.jc.services;

import lv.id.jc.biorhytm.Biorhythm;

import java.time.LocalDate;
import java.util.stream.LongStream;

public class TestIndicators implements Runnable {
    private final Biorhythm biorhythm;

    public TestIndicators(final Biorhythm biorhythm) {
        this.biorhythm = biorhythm;
    }

    public static void main(String[] args) {
        Biorhythm.primary().map(TestIndicators::new).forEach(TestIndicators::run);
    }

    @Override
    public void run() {
        System.out.println();
        final var birthday = LocalDate.of(1970, 6, 7);
        LongStream.rangeClosed(0, biorhythm.getPeriod() * 2L)
                .mapToObj(days -> biorhythm.new Value(birthday, birthday.plusDays(days)))
                .forEach(System.out::println);
    }
}
