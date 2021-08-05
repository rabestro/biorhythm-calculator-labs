package reports;

import biorhytms.Biorhythm;
import reports.format.WeeklyFormat;

import java.text.Format;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.stream.Stream;

public class WeeklyReport extends AbstractReport {
    private static final Format DAILY_FORMAT = new WeeklyFormat("%-12s %4d %%");

    public WeeklyReport() {
        super();
    }

    public WeeklyReport(final ReportData reportData) {
        super(reportData);
    }

    public static void main(String[] args) {
        new WeeklyReport().run();
    }

    @Override
    public void run() {
        int weekOfYear = date().get(ChronoField.ALIGNED_WEEK_OF_YEAR);
//        int weekOfYear = date.get(WeekFields.of(locale).weekOfYear());
        printf("format.weekly.top", date().getYear(), weekOfYear);
        weekDays().forEach(day -> printf("format.weekly.day", day,
                DAILY_FORMAT.format(Biorhythm.Physical.new Value(birthday(), day)),
                DAILY_FORMAT.format(Biorhythm.Emotional.new Value(birthday(), day)),
                DAILY_FORMAT.format(Biorhythm.Intellectual.new Value(birthday(), day)))
        );
    }

    private Stream<LocalDate> weekDays() {
        final var startDay = date().minusDays(date().getDayOfWeek().getValue() - 1);
        return Stream.iterate(startDay, day -> day.plusDays(1L))
                .limit(DayOfWeek.values().length);
    }
}
