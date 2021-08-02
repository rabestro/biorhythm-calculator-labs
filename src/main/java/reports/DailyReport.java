package reports;

import biorhytms.Biorhythm;
import lombok.val;

import java.time.temporal.ChronoUnit;

public class DailyReport extends AbstractReport {

    public DailyReport(final ReportData reportData) {
        super(reportData);
    }

    @Override
    public void run() {
        val days = ChronoUnit.DAYS.between(birthday(), date());

        System.out.println();
        System.out.println("Daily Biorhythm Summary:");

        System.out.println("\nPrimary Biorhythms\n");
        Biorhythm.primary()
                .map(biorhythm -> biorhythm.new Value(birthday(), date()))
                .map(Indicator::new)
                .forEach(System.out::println);

        System.out.println("\nSecondary Biorhythms\n");
        Biorhythm.secondary()
                .map(biorhythm -> biorhythm.new Value(birthday(), date()))
                .map(Indicator::new)
                .forEach(System.out::println);

    }
}
