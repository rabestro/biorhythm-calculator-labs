package lv.id.jc.biorhythm.service;

import lv.id.jc.biorhythm.model.Context;
import lv.id.jc.biorhythm.model.Biorhythm;

import java.time.LocalDate;
import java.util.stream.Stream;

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
        final var birthday = LocalDate.EPOCH;
        Stream.iterate(LocalDate.EPOCH, date -> date.plusDays(1L))
                .limit(biorhythm.getPeriod() * 2L)
                .map(date -> new Context(birthday, date))
                .map(context -> biorhythm.new Value(context))
                .forEach(System.out::println);

    }
}
