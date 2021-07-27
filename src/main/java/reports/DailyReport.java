package reports;

import biorhytms.Biorhythm;
import lombok.val;
import model.ReportData;

import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class DailyReport implements Runnable {
    private final ReportData reportData;

    public DailyReport(final ReportData reportData) {
        this.reportData = reportData;
    }

    @Override
    public void run() {
        val days = ChronoUnit.DAYS.between(reportData.getBirthday(), reportData.getDate());

        System.out.println();
        System.out.println("Daily Biorhythm Summary:");

        System.out.println("\nPrimary Biorhythms\n");
        Arrays.stream(Biorhythm.values())
                .filter(Biorhythm::isPrimary)
                .sorted(Comparator.comparing(Biorhythm::getPeriod))
                .map(biorhythm -> biorhythm.new Indicator(days))
                .forEach(System.out::println);

        System.out.println("\nSecondary Biorhythms\n");
        Arrays.stream(Biorhythm.values())
                .filter(Predicate.not(Biorhythm::isPrimary))
                .sorted(Comparator.comparing(Biorhythm::getPeriod))
                .map(biorhythm -> biorhythm.new Indicator(days))
                .forEach(System.out::println);

    }
}
