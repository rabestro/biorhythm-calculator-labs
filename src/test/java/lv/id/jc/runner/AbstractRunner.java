package lv.id.jc.runner;

import lombok.val;
import lv.id.jc.report.ReportData;

import java.util.Objects;
import java.util.Random;
import java.util.function.Function;

import static java.time.LocalDate.EPOCH;

abstract class AbstractRunner {
    private static final Random random = new Random();
    private static final int MAX_DAYS = 15_000;

    static Function<ReportData, Runnable> reportRunner;

    public static void main(String[] args) {
        Objects.requireNonNull(reportRunner);
        reportRunner.apply(getRandomData()).run();
    }

    static ReportData getRandomData() {
        val birthday = EPOCH.plusDays(random.nextInt(MAX_DAYS));
        val selected = birthday.plusDays(random.nextInt(MAX_DAYS));
        return new ReportData(birthday, selected);
    }

}
