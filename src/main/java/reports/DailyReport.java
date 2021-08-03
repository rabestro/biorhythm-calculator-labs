package reports;

import biorhytms.Biorhythm;
import lombok.val;

import java.time.temporal.ChronoUnit;

public class DailyReport extends AbstractReport {
    public DailyReport() {
        super();
    }

    public DailyReport(final ReportData reportData) {
        super(reportData);
    }

    public static void main(String[] args) {
        new DailyReport().run();
    }

    @Override
    public void run() {
        val days = ChronoUnit.DAYS.between(birthday(), date());

        System.out.println();
        System.out.println("Daily Biorhythm Summary:");

        System.out.println("\nPrimary Biorhythms\n");
        Biorhythm.primary()
                .map(biorhythm -> biorhythm.new Value(birthday(), date()))
                .forEach(System.out::println);

        System.out.println("\nSecondary Biorhythms\n");
        Biorhythm.secondary()
                .map(biorhythm -> biorhythm.new Value(birthday(), date()))
                .forEach(System.out::println);

    }
}
