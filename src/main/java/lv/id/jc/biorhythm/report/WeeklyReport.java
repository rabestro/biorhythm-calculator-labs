package lv.id.jc.biorhythm.report;

import lv.id.jc.biorhythm.model.Context;
import lv.id.jc.biorhythm.format.BiorhythmFormat;
import lv.id.jc.biorhythm.model.Biorhythm;
import lv.id.jc.biorhythm.ui.Component;

import java.text.Format;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.stream.Stream;

public class WeeklyReport extends Component {
    private final Format formatter;

    public WeeklyReport(final Context context) {
        super(context);
        formatter = new BiorhythmFormat(getString("biorhythm.format"));
    }

    @Override
    public void run() {
        final var weekOfYear = date().get(ChronoField.ALIGNED_WEEK_OF_YEAR);
//        int weekOfYear = date.get(WeekFields.of(locale).weekOfYear());

        printf("weekly.header.format", date().getYear(), weekOfYear);

        weekDays().forEach(day -> printf("weekly.day.format", day,
                formatter.format(Biorhythm.PHYSICAL.new Value(context.withDate(day))),
                formatter.format(Biorhythm.EMOTIONAL.new Value(context.withDate(day))),
                formatter.format(Biorhythm.INTELLECTUAL.new Value(context.withDate(day)))));
    }

    private Stream<LocalDate> weekDays() {
        final var startDay = date().minusDays(date().getDayOfWeek().getValue() - 1L);
        return Stream.iterate(startDay, day -> day.plusDays(1L))
                .limit(DayOfWeek.values().length);
    }
}
