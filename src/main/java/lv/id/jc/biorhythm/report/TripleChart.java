package lv.id.jc.biorhythm.report;

import lv.id.jc.biorhythm.model.Context;
import lv.id.jc.biorhythm.model.Biorhythm;
import lv.id.jc.biorhythm.ui.Component;

import java.util.stream.IntStream;

public class TripleChart extends Component {

    public TripleChart(final Context context) {
        super(context);
    }

    @Override
    public void run() {
        System.out.println();
        IntStream.range(0, 30).forEach(i -> {
            System.out.printf("%tF %21s %21s %21s%n", date(),
                    new Thermometer(Biorhythm.PHYSICAL.new Value(context)),
                    new Thermometer(Biorhythm.EMOTIONAL.new Value(context)),
                    new Thermometer(Biorhythm.INTELLECTUAL.new Value(context))
            );
            context.nextDay();
        });
    }
}
