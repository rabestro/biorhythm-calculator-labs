package lv.id.jc.biorhythm.report.monthly;

import lv.id.jc.biorhythm.model.Biorhythm;
import lv.id.jc.biorhythm.model.Context;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.stream.Stream;

public class Week {
    private final String biorhythmFormat;
    private final DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd EEE");
    private final String valueFormat;
    private final Context context;
    private final Month month;

    public Week(ResourceBundle resourceBundle, Context context, Month month) {
        biorhythmFormat = resourceBundle.getString("biorhythm.short.format");
        valueFormat = resourceBundle.getString("monthly.value.format");
        this.context = context;
        this.month = month;
    }

    public String getWeekReport(LocalDate localDate) {
        LocalDate start = localDate.with(DayOfWeek.MONDAY);
        int weekOfTheYear = start.get(ChronoField.ALIGNED_WEEK_OF_YEAR);
        StringBuilder sb = new StringBuilder();
        Arrays.stream(Line.values())
                .forEach(line -> {
                    Stream<LocalDate> stream = Stream.iterate(start, day -> day.plusDays(1)).limit(7);
                    switch (line) {
                        case DATE:
                            sb.append(String.format(valueFormat, "week #" + weekOfTheYear));
                            stream.map(dateFormat::format).forEach(day -> sb.append(String.format(valueFormat, day)));
                            break;
                        case PHYSICAL:
                            sb.append(String.format(valueFormat, line + ":"));
                            getBiorhythms(sb, stream, Biorhythm.PHYSICAL);
                            break;
                        case EMOTIONAL:
                            sb.append(String.format(valueFormat, line + ":"));
                            getBiorhythms(sb, stream, Biorhythm.EMOTIONAL);
                            break;
                        case INTELLECTUAL:
                            sb.append(String.format(valueFormat, line + ":"));
                            getBiorhythms(sb, stream, Biorhythm.INTELLECTUAL);
                            break;
                        default:
                            sb.append(String.format(valueFormat, " "));
                    }
                    sb.append("\n");
                });
        return sb.toString();
    }

    private void getBiorhythms(StringBuilder sb, Stream<LocalDate> stream, Biorhythm biorhythm) {
        stream.map(day -> {
            if (!day.getMonth().equals(month)) {
                return "";
            }
            int value = biorhythm.getIndicatorOf(context.withDate(day)).percent();
            return String.format(biorhythmFormat, value);
        }).forEach(day -> sb.append(String.format(valueFormat, day)));
    }

    enum Line {
        DATE("Date"), PHYSICAL("Ph"), EMOTIONAL("Em"), INTELLECTUAL("In");

        private final String text;

        Line(String text) {
            this.text = text;
        }

        @Override
        public String toString() {
            return text;
        }
    }
}
