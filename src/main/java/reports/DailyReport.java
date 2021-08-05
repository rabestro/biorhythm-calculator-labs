package reports;

import biorhytms.Biorhythm;
import reports.format.DailyFormat;

import java.text.Format;
import java.util.Arrays;

public class DailyReport extends AbstractReport {
    private static final Format DAILY_FORMAT = new DailyFormat();

    public DailyReport(final ReportData reportData) {
        super(reportData);
    }

    @Override
    public void run() {
        final var daily = Arrays.stream(Biorhythm.values())
                .map(biorhythm -> biorhythm.new Value(birthday(), date()))
                .map(DAILY_FORMAT::format)
                .toArray();

        printf("format.daily", daily);
    }
}
