package lv.id.jc.biorhytm.report;

import lv.id.jc.biorhytm.Biorhythm;

import java.util.stream.IntStream;

public class TripleChart extends AbstractReport {
    public TripleChart() {
        super();
    }

    public TripleChart(final ReportData reportData) {
        super(reportData);
    }

    public static void main(String[] args) {
        new TripleChart().run();
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
            reportData.nextDay();
        });
    }
}
