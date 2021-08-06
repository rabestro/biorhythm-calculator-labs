package lv.id.jc.report;

import lv.id.jc.biorhytm.Biorhythm;
import lv.id.jc.report.format.BiorhythmFormat;

import java.text.Format;
import java.util.Arrays;

public class DailyReport extends AbstractReport {
    private final Format formatter;

    public DailyReport(final Context context) {
        super(context);
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
