package report;

import biorhytms.Biorhythm;
import report.format.SummaryFormat;

import java.util.stream.Stream;

public class SummaryReport extends AbstractReport {
    private static final SummaryFormat SUMMARY_FORMAT = new SummaryFormat();

    public SummaryReport() {
        super();
    }

    public SummaryReport(final ReportData reportData) {
        super(reportData);
    }

    public static void main(String[] args) {
        new SummaryReport().run();
    }

    @Override
    public void run() {
        System.out.println();
        System.out.println("Today's Biorhythm Summary:");
        System.out.println();

        biorhythms().forEach(System.out::println);

        System.out.println();

        biorhythms()
                .map(SUMMARY_FORMAT::format)
                .forEach(System.out::println);
    }

    private Stream<Biorhythm.Value> biorhythms() {
        return Biorhythm.primary().map(biorhythm -> biorhythm.new Value(birthday(), date()));
    }

}