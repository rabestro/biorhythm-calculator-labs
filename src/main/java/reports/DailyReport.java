package reports;

import biorhytms.Biorhythm;
import lombok.val;

import java.time.temporal.ChronoUnit;

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
        Biorhythm.primary()
                .map(biorhythm -> biorhythm.new Value(days))
                .map(Indicator::new)
                .forEach(System.out::println);

        System.out.println("\nSecondary Biorhythms\n");
        Biorhythm.secondary()
                .map(biorhythm -> biorhythm.new Value(days))
                .map(Indicator::new)
                .forEach(System.out::println);

    }
}
