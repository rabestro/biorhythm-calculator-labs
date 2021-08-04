package reports;

import biorhytms.Biorhythm;
import biorhytms.format.WeeklyFormat;

import java.text.Format;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.stream.Stream;

public class WeeklyReport extends AbstractReport {
    private static final DateTimeFormatter FIRST_LINE = DateTimeFormatter.ofPattern("EEEE");
    private static final DateTimeFormatter SECOND_LINE = DateTimeFormatter.ofPattern("MMMM ");
    private static final DateTimeFormatter THIRD_LINE = DateTimeFormatter.ofPattern("yyyy");
    private static final String LINE_SEPARATOR =
            "+-----------------+------------------------------------------------------------";
    private static final String TEMPLATE = LINE_SEPARATOR + "%n" + "| %-15s | %s%n".repeat(3);
    private static final Format DAILY_FORMAT = new WeeklyFormat();

    public WeeklyReport() {
        super();
    }

    public WeeklyReport(final ReportData reportData) {
        super(reportData);
    }

    public static void main(String[] args) {
        new WeeklyReport().run();
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
        println("report.weekly.top");
        weekDays().forEach(day -> println("report.weekly.day",
                LONG_DATE.format(day),
                DAILY_FORMAT.format(Biorhythm.Physical.new Value(birthday(), day)),
                DAILY_FORMAT.format(Biorhythm.Emotional.new Value(birthday(), day)),
                DAILY_FORMAT.format(Biorhythm.Intellectual.new Value(birthday(), day)))
        );
    }

    public void old() {
        int weekOfYear = date().get(ChronoField.ALIGNED_WEEK_OF_YEAR);
        System.out.println();
        System.out.println("|  Weekly Report  |");
//        int weekOfYear = date.get(WeekFields.of(locale).weekOfYear());
        weekDays().forEach(this::printDay);

        System.out.println(LINE_SEPARATOR);
    }

    private Stream<LocalDate> weekDays() {
        final var startDay = date().minusDays(date().getDayOfWeek().getValue() - 1);
        return Stream.iterate(startDay, day -> day.plusDays(1L))
                .limit(DayOfWeek.values().length);
    }
}
