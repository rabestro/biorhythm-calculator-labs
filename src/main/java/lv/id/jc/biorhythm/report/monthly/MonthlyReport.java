package lv.id.jc.biorhythm.report.monthly;

import lv.id.jc.biorhythm.command.AbstractCommand;
import lv.id.jc.biorhythm.model.Context;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.stream.Stream;

public class MonthlyReport extends AbstractCommand {

    public MonthlyReport(Context context) {
        super(context);
    }

    @Override
    public void run() {
        final LocalDate date = date();
        final Month month = date.getMonth();
        final Week week = new Week(resourceBundle, context, month);
        final StringBuilder sb = new StringBuilder(
                String.format(
                        getString("monthly.header.format"),
                        date.getYear(),
                        date.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault())));

        LocalDate start = date.withDayOfMonth(1);
        Stream.iterate(start, day -> day.plusDays(7))
                .limit(6)
                .filter(day -> {
                    LocalDate monday = day.with(DayOfWeek.MONDAY);
                    LocalDate sunday = day.with(DayOfWeek.SUNDAY);
                    return monday.getMonth().equals(month) || sunday.getMonth().equals(month);
                })
                .forEach(day -> {
                    sb.append(week.getWeekReport(day));
                    sb.append("\n");
                });
        println(sb.toString());
    }
}
