package lv.id.jc.biorhythm.command;

import lv.id.jc.biorhythm.model.Context;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.regex.Pattern;

import static java.lang.System.Logger.Level.TRACE;

public class DateMover extends AbstractCommand {
    private static final Pattern COMMAND_PATTERN = Pattern.compile("" +
            "(?<sign>[-+])" +   // Plus or Minus
            "(?<number>\\d+)" + // How much
            "(?<unit>[dwmyq])"  // Days, Weeks, Months, Years and Quarters
    );
    private static final Map<String, BiFunction<LocalDate, Long, LocalDate>> MOVE_OPERATORS = Map.of(
            "+d", LocalDate::plusDays, "-d", LocalDate::minusDays,
            "+w", LocalDate::plusWeeks, "-w", LocalDate::minusWeeks,
            "+m", LocalDate::plusMonths, "-m", LocalDate::minusMonths,
            "+y", LocalDate::plusYears, "-y", LocalDate::minusYears,
            "+f", DateMover::plusFortnight, "-f", DateMover::minusFortnight
    );

    private static Period fortnight(Number number) {
        return Period.of(0, 0, 14 * number.intValue());
    }

    private static LocalDate plusFortnight(LocalDate date, Number number) {
        return date.plus(fortnight(number));
    }

    private static LocalDate minusFortnight(LocalDate date, Number number) {
        return date.minus(fortnight(number));
    }

    public DateMover(Context context) {
        super(context);
    }

    @Override
    public Boolean apply(String request) {
        final var matcher = COMMAND_PATTERN.matcher(request);
        if (!matcher.matches()) {
            return false;
        }
        final var sign = matcher.group("sign");
        final var unit = matcher.group("unit");
        final var number = Long.parseLong(matcher.group("number"));
        LOGGER.log(TRACE, "sign = {0}, number = {1}, unit = {2}", sign, number, unit);
        setDate(MOVE_OPERATORS.get(sign + unit).apply(date(), number));
        return true;
    }
}
