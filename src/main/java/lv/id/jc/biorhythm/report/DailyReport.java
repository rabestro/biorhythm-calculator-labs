package lv.id.jc.biorhythm.report;

import lv.id.jc.biorhythm.model.Biorhythm;
import lv.id.jc.biorhythm.model.Context;
import lv.id.jc.biorhythm.model.Indicator;
import lv.id.jc.biorhythm.ui.command.AbstractCommand;

import static lv.id.jc.biorhythm.format.IndicatorTemplateFormat.DAILY;

public class DailyReport extends AbstractCommand {

    public DailyReport(final Context context) {
        super(context);
    }

    @Override
    public void run() {

        final var daily = Biorhythm
                .stream()
                .map(context::getIndicatorOf)
                .map(DAILY::format)
                .toArray();

        final var average = 100 * Biorhythm
                .primary()
                .map(context::getIndicatorOf)
                .mapToDouble(Indicator::value)
                .average()
                .orElse(0.0);

        printf("daily.header", birthday(), date());

        printf("daily.report",
                daily[0], daily[1], daily[2], average,
                daily[3], daily[4], daily[5], daily[6]);
    }
}
