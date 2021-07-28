package reports;

import biorhytms.Biorhythm;

import java.util.function.Function;

public class SummaryReport extends AbstractReport {
    private static final Function<Indicator, String> ONE_LINE = indicator -> String.format("%s", indicator);

    public SummaryReport(final ReportData reportData) {
        super(reportData);
    }

    @Override
    public void run() {
        System.out.println();
        System.out.println("Today's Biorhythm Summary:");
        System.out.println();

        Biorhythm.primary()
                .map(biorhythm -> biorhythm.new Value(reportData.getDays()))
                .map(Indicator::new)
                .forEach(System.out::println);
    }
}
