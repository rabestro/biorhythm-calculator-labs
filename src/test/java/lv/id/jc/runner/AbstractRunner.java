package lv.id.jc.runner;

import lv.id.jc.biorhythm.model.Context;

import java.util.Objects;
import java.util.Random;
import java.util.function.Function;

import static java.time.LocalDate.EPOCH;

abstract class AbstractRunner {
    private static final Random random = new Random();
    private static final int MAX_DAYS = 15_000;

    static Function<Context, Runnable> runner;

    public static void main(String[] args) {
        Objects.requireNonNull(runner);
        runner.apply(getRandomData()).run();
    }

    static Context getRandomData() {
        final var birthday = EPOCH.plusDays(random.nextInt(MAX_DAYS));
        final var selected = birthday.plusDays(random.nextInt(MAX_DAYS));
        return new Context(birthday, selected);
    }

}
