package lv.id.jc.biorhythm.command;

import lv.id.jc.biorhythm.model.Context;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.MonthDay;
import java.time.temporal.TemporalAdjuster;
import java.util.Optional;
import java.util.regex.Pattern;

public class DateWith extends DateCommand {
    private static final Pattern MONTH_DAY;
    private static final Pattern ADJUSTER;

    static {
        MONTH_DAY = Pattern.compile("\\d{2}-\\d{2}");
        ADJUSTER = Pattern.compile("(?<sign>[-+])?(?<unit>\\w+)");
    }

    public DateWith(Context context) {
        super(context);
    }

    @Override
    public boolean test(String request) {
        return getAdjuster(request).map(this::adjustDate).orElse(false);
    }

    private boolean adjustDate(final TemporalAdjuster adjuster) {
        final var newDate = context.date().with(adjuster);
        context.setDate(newDate);
        return true;
    }

    private Optional<TemporalAdjuster> getAdjuster(String request) {
        if (MONTH_DAY.matcher(request).matches()) {
            return Optional.of(MonthDay.parse("--" + request));
        }
        final var matcher = ADJUSTER.matcher(request.toUpperCase());
        if (!matcher.matches()) {
            return Optional.empty();
        }
        final var sign = matcher.group("sign");
        final var unit = matcher.group("unit");

        if (MONTHS.contains(unit)) {
            return Optional.of(Month.valueOf(unit));
        }
        if (DAYS_OF_WEEK.contains(unit)) {
            return Optional.of(DayOfWeek.valueOf(unit));
        }
        return Optional.empty();
    }

}
