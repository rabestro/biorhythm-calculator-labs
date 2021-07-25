package services;

import biorhytms.Biorhythm;

import java.util.stream.LongStream;

public class TestIndicators implements Runnable {
    private final Biorhythm biorhythm;

    public TestIndicators(final Biorhythm biorhythm) {
        this.biorhythm = biorhythm;
    }

    @Override
    public void run() {
        System.out.println();
        LongStream.rangeClosed(0, biorhythm.getPeriod() * 2L)
                .mapToObj(days -> biorhythm.new Indicator(days))
                .forEach(System.out::println);
    }
}
