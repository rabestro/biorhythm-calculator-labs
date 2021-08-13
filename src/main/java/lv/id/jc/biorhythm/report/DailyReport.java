package lv.id.jc.biorhythm.report;

import lv.id.jc.biorhythm.format.IndicatorTemplateFormat;
import lv.id.jc.biorhythm.model.Biorhythm;
import lv.id.jc.biorhythm.model.Context;
import lv.id.jc.biorhythm.model.Indicator;
import lv.id.jc.biorhythm.ui.Component;

import java.text.Format;
import java.util.Arrays;

public class DailyReport extends Component {
    private final Format indicatorFormatter;

    public DailyReport(final Context context) {
        super(context);
        indicatorFormatter = new IndicatorTemplateFormat(getString("daily.biorhythm.format"));
    }

    @Override
    public void run() {

        final var daily = Arrays
                .stream(Biorhythm.values())
                .map(context::getIndicatorOf)
                .map(indicatorFormatter::format)
                .toArray();

        final var average = 100 * Biorhythm.primary()
                .map(context::getIndicatorOf)
                .mapToDouble(Indicator::getValue)
                .average()
                .orElse(0.0);

        printf("daily.header", birthday(), date());

        printf("daily.report",
                daily[0], daily[1], daily[2], average,
                daily[3], daily[4], daily[5], daily[6]);
    }
}
