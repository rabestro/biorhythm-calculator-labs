package report;

import biorhytms.Biorhythm;
import report.format.BiorhythmTemplateFormat;
import report.format.SummaryFormat;

import java.text.Format;
import java.util.stream.Stream;

public class SummaryReport extends AbstractReport {
    private static final Format SUMMARY_FORMAT = new SummaryFormat();

    public SummaryReport(final ReportData reportData) {
        super(reportData);
    }

    @Override
    public void run() {
        printf("summary.header.format");
        var formatter = new BiorhythmTemplateFormat(getString("short.biorhythm.format"));
        biorhythms().map(formatter::format).forEach(this::println);

        println();

        biorhythms()
                .map(SUMMARY_FORMAT::format)
                .forEach(System.out::println);
    }

    private Stream<Biorhythm.Value> biorhythms() {
        return Biorhythm.primary().map(biorhythm -> biorhythm.new Value(birthday(), date()));
    }

}
