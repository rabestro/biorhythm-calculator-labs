package lv.id.jc.biorhythm.report;

import lv.id.jc.biorhythm.model.Biorhythm;

import java.util.stream.IntStream;

public class TripleChart extends AbstractReport {

    public TripleChart(final Context context) {
        super(context);
    }

    @Override
    public void run() {
        System.out.println();
        IntStream.range(0, 30).forEach(i -> {
            System.out.printf("%tF %21s %21s %21s%n", date(),
                    new Thermometer(Biorhythm.Physical.new Value(birthday(), date())),
                    new Thermometer(Biorhythm.Emotional.new Value(birthday(), date())),
                    new Thermometer(Biorhythm.Intellectual.new Value(birthday(), date()))
            );
            context.nextDay();
        });
    }
}
