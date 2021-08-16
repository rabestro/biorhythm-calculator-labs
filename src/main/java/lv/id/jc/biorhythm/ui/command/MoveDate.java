package lv.id.jc.biorhythm.ui.command;

import lv.id.jc.biorhythm.model.Context;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.regex.Pattern;

import static java.lang.System.Logger.Level.TRACE;

public class MoveDate extends AbstractCommand {
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
            "+q", (d, n) -> d.plus(Period.of(0, n.intValue() * 3, 0)),
            "-q", (d, n) -> d.minus(Period.of(0, n.intValue() * 3, 0))
    );

    public MoveDate(Context context) {
        super(context);
    }

    @Override
    public boolean test(String command) {
        final var plusMinus = COMMAND_PATTERN.matcher(command);
        final var isValidCommand = plusMinus.matches();

        if (isValidCommand) {
            final var sign = plusMinus.group(1);
            final var unit = plusMinus.group(3);
            final var number = Long.parseLong(plusMinus.group(2));
            LOGGER.log(TRACE, "sign = {0}, number = {1}, unit = {2}", sign, number, unit);
            runnable = () -> setDate(MOVE_OPERATORS.get(sign + unit).apply(date(), number));
        }
        return isValidCommand;
    }

    @Override
    public Boolean apply(String request) {
        final var matcher = COMMAND_PATTERN.matcher(command);
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
