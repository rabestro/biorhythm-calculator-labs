package lv.id.jc.tests;

import lv.id.jc.biorhythm.model.Biorhythm;
import lv.id.jc.biorhythm.model.Context;

import java.time.LocalDate;
import java.util.stream.Stream;

public class TestIndicator implements Runnable {
    private final Biorhythm biorhythm;

    public TestIndicator(final Biorhythm biorhythm) {
        this.biorhythm = biorhythm;
    }

    public static void main(String[] args) {
        Biorhythm.primary().map(TestIndicator::new).forEach(TestIndicator::run);
    }

    @Override
    public void run() {
        System.out.println();
        final var birthday = LocalDate.EPOCH;
        Stream.iterate(LocalDate.EPOCH, date -> date.plusDays(1L))
                .limit(biorhythm.period() * 2L)
                .map(date -> new Context(birthday, date))
                .map(biorhythm::getIndicatorOf)
                .forEach(System.out::println);

    }
}
