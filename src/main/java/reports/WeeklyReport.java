package reports;

import biorhytms.Biorhythm;

import java.time.format.DateTimeFormatter;
import java.util.stream.IntStream;

public class WeeklyReport extends AbstractReport {
    private static final String TEMPLATE = "| %-13s | %s%n".repeat(3);
    private static final DateTimeFormatter FIRST_LINE = DateTimeFormatter.ofPattern("EEEE");
    private static final DateTimeFormatter SECOND_LINE = DateTimeFormatter.ofPattern("dd MMMM");
    private static final DateTimeFormatter THIRD_LINE = DateTimeFormatter.ofPattern("yyyy");
    private static final String LINE_SEPARATOR =
            "+---------------+------------------------------------------------------------";

    public WeeklyReport(final ReportData reportData) {
        super(reportData);
    }

    static String day(ReportData data) {
        return String.format(TEMPLATE,
                data.getDate().format(FIRST_LINE), Biorhythm.Physical.new Value(data.getDays()),
                data.getDate().format(SECOND_LINE), Biorhythm.Emotional.new Value(data.getDays()),
                data.getDate().format(THIRD_LINE), Biorhythm.Intellectual.new Value(data.getDays())
        );
    }

    @Override
    public void run() {
        System.out.println();
        System.out.println("| Weekly Report |");
        IntStream.range(0, 7).forEach(i -> {
            System.out.println(LINE_SEPARATOR);
            System.out.print(day(reportData));
            reportData.nextDay();
        });
        System.out.println(LINE_SEPARATOR);
    }
}
