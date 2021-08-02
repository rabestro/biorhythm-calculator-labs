package reports;

import biorhytms.Biorhythm;

import java.util.stream.IntStream;

public class TripleChart extends AbstractReport {

    public TripleChart(final ReportData reportData) {
        super(reportData);
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
