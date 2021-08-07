package lv.id.jc.biorhythm.report;

import lv.id.jc.biorhythm.Component;
import lv.id.jc.biorhythm.Context;
import lv.id.jc.biorhythm.model.Biorhythm;
import lv.id.jc.biorhythm.format.BiorhythmFormat;

import java.text.Format;
import java.util.Arrays;

public class DailyReport extends Component {
    private final Format formatter;

    public DailyReport(final Context context) {
        super(context);
        formatter = new BiorhythmFormat(getString("daily.biorhythm.format"));
    }

    @Override
    public void run() {
        final var daily = Arrays.stream(Biorhythm.values())
                .map(biorhythm -> biorhythm.new Value(context))
                .map(formatter::format)
                .toArray();

        printf("daily.report.format", daily);
    }
}
