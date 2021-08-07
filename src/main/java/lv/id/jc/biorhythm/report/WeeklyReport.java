package lv.id.jc.biorhythm.report;

import lv.id.jc.biorhythm.Component;
import lv.id.jc.biorhythm.Context;
import lv.id.jc.biorhythm.model.Biorhythm;
import lombok.val;
import lv.id.jc.biorhythm.format.BiorhythmFormat;

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
        val weekOfYear = date().get(ChronoField.ALIGNED_WEEK_OF_YEAR);
//        int weekOfYear = date.get(WeekFields.of(locale).weekOfYear());

        printf("weekly.header.format", date().getYear(), weekOfYear);

        weekDays().forEach(day -> printf("weekly.day.format", day,
                formatter.format(Biorhythm.Physical.new Value(birthday(), day)),
                formatter.format(Biorhythm.Emotional.new Value(birthday(), day)),
                formatter.format(Biorhythm.Intellectual.new Value(birthday(), day)))
        );
    }

    private Stream<LocalDate> weekDays() {
        final var startDay = date().minusDays(date().getDayOfWeek().getValue() - 1);
        return Stream.iterate(startDay, day -> day.plusDays(1L))
                .limit(DayOfWeek.values().length);
    }
}
