package reports;

import biorhytms.Biorhythm;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

public class WeeklyReport extends AbstractReport {
    private static final DateTimeFormatter FIRST_LINE = DateTimeFormatter.ofPattern("EEEE");
    private static final DateTimeFormatter SECOND_LINE = DateTimeFormatter.ofPattern("MMMM ");
    private static final DateTimeFormatter THIRD_LINE = DateTimeFormatter.ofPattern("yyyy");
    private static final String LINE_SEPARATOR =
            "+-----------------+------------------------------------------------------------";
    private static final String TEMPLATE = LINE_SEPARATOR + "%n" + "| %-15s | %s%n".repeat(3);

    public WeeklyReport(final ReportData reportData) {
        super(reportData);
    }

    void printDay(final LocalDate localDate) {
        System.out.format(TEMPLATE,
                localDate.format(FIRST_LINE), Biorhythm.Physical.new Value(birthday(), localDate),
                localDate.format(SECOND_LINE) + dayOrdinal(localDate.getDayOfMonth()),
                Biorhythm.Emotional.new Value(birthday(), localDate),
                localDate.format(THIRD_LINE), Biorhythm.Intellectual.new Value(birthday(), localDate)
        );
    }

    @Override
    public void run() {
        System.out.println();
        System.out.println("|  Weekly Report  |");

        Stream.iterate(reportData.getDate(), d -> d.plusDays(1L)).limit(7).forEach(this::printDay);

        System.out.println(LINE_SEPARATOR);
    }
}
