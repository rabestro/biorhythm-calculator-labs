package lv.id.jc.biorhythm.command;

import lv.id.jc.biorhythm.model.Context;

import java.time.DayOfWeek;
import java.time.temporal.TemporalAdjusters;
import java.util.regex.Pattern;

/**
 * Commands:
 * next {dayOfWeek}
 * prev {dayOfWeek}
 */
public class DateAdjuster extends DateCommand {
    private static final Pattern NEXT_PREV = Pattern.compile(
            "(?<sign>next|prev) (?<unit>\\w+)", Pattern.CASE_INSENSITIVE);

    public DateAdjuster(Context context) {
        super(context);
    }

    @Override
    public boolean test(String request) {
        final var matcher = NEXT_PREV.matcher(request.toUpperCase());
        if (!matcher.matches()) {
            return false;
        }
        final var sign = matcher.group("sign");
        final var unit = matcher.group("unit");

        if (DAYS_OF_WEEK.contains(unit)) {
            final var adjuster = sign.equals("NEXT")
                    ? TemporalAdjusters.next(DayOfWeek.valueOf(unit))
                    : TemporalAdjusters.previous(DayOfWeek.valueOf(unit));
            context.setDate(context.getDate().with(adjuster));
            return true;
        }
        return false;
    }
}
