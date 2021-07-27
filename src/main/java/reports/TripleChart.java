package reports;

import biorhytms.Biorhythm;
import biorhytms.Thermometer;

import java.util.stream.IntStream;

public class TripleChart implements Runnable {
    private final ReportData reportData;

    public TripleChart(final ReportData reportData) {
        this.reportData = reportData;
    }

    @Override
    public void run() {
        System.out.println();
        IntStream.range(0, 30).forEach(i -> {
            System.out.printf("%tF %21s %21s %21s%n", reportData.getDate(),
                    new Thermometer(Biorhythm.Physical.new Indicator(reportData.getDays())),
                    new Thermometer(Biorhythm.Emotional.new Indicator(reportData.getDays())),
                    new Thermometer(Biorhythm.Intellectual.new Indicator(reportData.getDays()))
            );
            reportData.nextDay();
        });
    }
}
