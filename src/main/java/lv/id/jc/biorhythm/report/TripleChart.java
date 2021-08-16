package lv.id.jc.biorhythm.report;

import lv.id.jc.biorhythm.model.Biorhythm;
import lv.id.jc.biorhythm.model.Context;
import lv.id.jc.biorhythm.ui.command.AbstractCommand;

import java.util.stream.IntStream;

public class TripleChart extends AbstractCommand {

    public TripleChart(final Context context) {
        super(context);
    }

    @Override
    public void run() {
        System.out.println();
        IntStream.range(0, 30).forEach(i -> {
            System.out.printf("%tF %21s %21s %21s%n", date(),
                    new Thermometer(context.getIndicatorOf(Biorhythm.PHYSICAL)),
                    new Thermometer(context.getIndicatorOf(Biorhythm.EMOTIONAL)),
                    new Thermometer(context.getIndicatorOf(Biorhythm.INTELLECTUAL))
            );
            context.nextDay();
        });
    }
}
