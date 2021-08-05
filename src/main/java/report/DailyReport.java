package report;

import biorhytms.Biorhythm;
import report.format.BiorhythmTemplateFormat;

import java.text.Format;
import java.util.Arrays;

public class DailyReport extends AbstractReport {
    private final Format formatter;

    public DailyReport(final ReportData reportData) {
        super(reportData);
        formatter = new BiorhythmTemplateFormat(getString("daily.biorhythm.format"));
    }

    @Override
    public void run() {
        final var daily = Arrays.stream(Biorhythm.values())
                .map(biorhythm -> biorhythm.new Value(birthday(), date()))
                .map(formatter::format)
                .toArray();

        printf("daily.report.format", daily);
    }
}
