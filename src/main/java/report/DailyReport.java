package report;

import biorhytm.Biorhythm;
import report.format.BiorhythmFormat;

import java.text.Format;
import java.util.Arrays;

public class DailyReport extends AbstractReport {
    private final Format formatter;

    public DailyReport(final ReportData reportData) {
        super(reportData);
        formatter = new BiorhythmFormat(getString("daily.biorhythm.format"));
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
