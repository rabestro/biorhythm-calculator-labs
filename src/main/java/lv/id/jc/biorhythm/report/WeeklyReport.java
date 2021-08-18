package lv.id.jc.biorhythm.report;

import lv.id.jc.biorhythm.command.AbstractCommand;
import lv.id.jc.biorhythm.format.IndicatorTemplateFormat;
import lv.id.jc.biorhythm.model.Biorhythm;
import lv.id.jc.biorhythm.model.Context;

import java.text.Format;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.stream.Stream;

import static java.time.DayOfWeek.MONDAY;

public class WeeklyReport extends AbstractCommand {
    private final Format formatter;

    public WeeklyReport(final Context context) {
        super(context);
        formatter = new IndicatorTemplateFormat(getString("biorhythm.format"));
    }

    @Override
    public void run() {
        final var weekOfYear = date().get(ChronoField.ALIGNED_WEEK_OF_YEAR);
        printf("weekly.header.format", date().getYear(), weekOfYear);

        weekDays().forEach(day -> printf("weekly.day.format", day,
                formatter.format(context.withDate(day).getIndicatorOf(Biorhythm.PHYSICAL)),
                formatter.format(context.withDate(day).getIndicatorOf(Biorhythm.EMOTIONAL)),
                formatter.format(context.withDate(day).getIndicatorOf(Biorhythm.INTELLECTUAL))));
    }

    private Stream<LocalDate> weekDays() {
        return Stream.iterate(date().with(MONDAY), day -> day.plusDays(1L))
                .limit(DayOfWeek.values().length);
    }
}
