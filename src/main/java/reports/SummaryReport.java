package reports;

import biorhytms.Biorhythm;

import java.util.stream.Stream;

public class SummaryReport extends AbstractReport {

    public SummaryReport(final ReportData reportData) {
        super(reportData);
    }

    @Override
    public void run() {
        System.out.println();
        System.out.println("Today's Biorhythm Summary:");
        System.out.println();

        biorhythms().forEach(System.out::println);

        System.out.println();

        biorhythms()
                .map(Indicator::getFull)
                .forEach(System.out::println);
    }

    private Stream<Indicator> biorhythms() {
        return Biorhythm.primary()
                .map(biorhythm -> biorhythm.new Value(birthday(), date()))
                .map(Indicator::new);
    }

}
