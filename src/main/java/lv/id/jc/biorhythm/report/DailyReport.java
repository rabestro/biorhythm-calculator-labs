package lv.id.jc.biorhythm.report;

import lv.id.jc.biorhythm.Context;
import lv.id.jc.biorhythm.format.BiorhythmFormat;
import lv.id.jc.biorhythm.model.Biorhythm;
import lv.id.jc.biorhythm.ui.Component;

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
        final var average = Biorhythm.primary()
                .map(biorhythm -> biorhythm.new Value(context))
                .mapToDouble(Biorhythm.Value::getValue)
                .average().orElse(0.0);
        printf("daily.header", birthday(), date());
        printf("daily.report", 100 * average,
                daily[0], daily[1], daily[2],
                daily[3], daily[4], daily[5], daily[6]);
    }
}
