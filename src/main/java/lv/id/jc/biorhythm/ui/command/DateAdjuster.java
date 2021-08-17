package lv.id.jc.biorhythm.ui.command;

import lv.id.jc.biorhythm.model.Context;

import java.time.DayOfWeek;
import java.time.Month;
import java.time.MonthDay;
import java.time.temporal.TemporalAdjuster;
import java.util.Optional;
import java.util.regex.Pattern;

import static java.util.Arrays.stream;

public class DateAdjuster extends AbstractCommand {
    private static final Pattern MONTH_DAY = Pattern.compile("\\d{2}-\\d{2}");

    public DateAdjuster(Context context) {
        super(context);
    }

    @Override
    public Boolean apply(String request) {
        return getAdjuster(request).map(this::adjustDate).orElse(false);
    }

    private boolean adjustDate(final TemporalAdjuster adjuster) {
        final var newDate = date().with(adjuster);
        setDate(newDate);
        return true;
    }

    private Optional<TemporalAdjuster> getAdjuster(String request) {
        if (MONTH_DAY.matcher(request).matches()) {
            return Optional.of(MonthDay.parse("--" + request));
        }
        final var unit = request.toUpperCase();
        if (stream(Month.values()).map(Enum::name).anyMatch(unit::equals)) {
            return Optional.of(Month.valueOf(unit));
        }
        if (stream(DayOfWeek.values()).map(Enum::name).anyMatch(unit::equals)) {
            return Optional.of(DayOfWeek.valueOf(unit));
        }
        return Optional.empty();
    }

}
