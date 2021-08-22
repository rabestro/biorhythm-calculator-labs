package lv.id.jc.biorhythm.report.fortnight;

import lv.id.jc.biorhythm.command.AbstractCommand;
import lv.id.jc.biorhythm.model.Context;
import lv.id.jc.biorhythm.report.monthly.Week;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.stream.Stream;

public class FortnightReport extends AbstractCommand {
    public FortnightReport(Context context) {
        super(context);
    }

    @Override
    public void run() {
        final LocalDate date = date();
        final Week week = new Week(resourceBundle, context, null);
        final StringBuilder sb = new StringBuilder(
                format(
                        getString("fortnight.header.format"),
                        date.getYear(),
                        date.getMonth().getDisplayName(TextStyle.FULL, Locale.getDefault())));
        Stream.iterate(date, day -> day.plusDays(7))
                .limit(2)
                .forEach(day -> {
                    sb.append(week.getWeekReport(day));
                    sb.append("\n");
                });
        println(sb.toString());

    }
}
