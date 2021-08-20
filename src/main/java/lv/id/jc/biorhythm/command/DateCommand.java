package lv.id.jc.biorhythm.command;

import lv.id.jc.biorhythm.model.Context;

import java.time.DayOfWeek;
import java.time.Month;
import java.util.Set;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toUnmodifiableSet;

abstract class DateCommand implements Command {
    static final System.Logger LOGGER = System.getLogger("Date Command");

    static final Set<String> MONTHS;
    static final Set<String> DAYS_OF_WEEK;

    static {
        MONTHS = stream(Month.values())
                .map(Enum::name)
                .collect(toUnmodifiableSet());

        DAYS_OF_WEEK = stream(DayOfWeek.values())
                .map(Enum::name)
                .collect(toUnmodifiableSet());
    }

    final Context context;

    DateCommand(Context context) {
        this.context = context;
    }

}
