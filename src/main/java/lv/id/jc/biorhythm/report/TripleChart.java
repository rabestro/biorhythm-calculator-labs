package lv.id.jc.biorhythm.report;

import lv.id.jc.biorhythm.command.AbstractCommand;
import lv.id.jc.biorhythm.model.Context;

import java.util.stream.Stream;

import static lv.id.jc.biorhythm.model.Biorhythm.*;

public class TripleChart extends AbstractCommand {

    public TripleChart(final Context context) {
        super(context);
    }

    @Override
    public void run() {
        println();
        printf("           [%-21s] [%-21s] [%-21s]%n", PHYSICAL, EMOTIONAL, INTELLECTUAL);
        Stream.iterate(context.getDate(), date -> date.plusDays(1L))
                .map(context::withDate)
                .limit(30)
                .forEach(c -> printf("%tF %23s %23s %23s%n", c.getDate(),
                        new Thermometer(c.getIndicatorOf(PHYSICAL)),
                        new Thermometer(c.getIndicatorOf(EMOTIONAL)),
                        new Thermometer(c.getIndicatorOf(INTELLECTUAL)))
                );
    }
}
