package lv.id.jc.biorhythm.command;

import lv.id.jc.biorhythm.Context;
import lv.id.jc.biorhythm.ui.Component;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.regex.Pattern;

import static java.lang.System.Logger.Level.TRACE;

public class MoveDate extends Component {
    private static final Pattern PLUS_MINUS = Pattern.compile("([-+])(\\d+)([dwmyq])");
    private static final Map<String, BiFunction<LocalDate, Long, LocalDate>> MOVE_OPERATORS = Map.of(
            "+d", LocalDate::plusDays, "-d", LocalDate::minusDays,
            "+w", LocalDate::plusWeeks, "-w", LocalDate::minusWeeks,
            "+m", LocalDate::plusMonths, "-m", LocalDate::minusMonths,
            "+y", LocalDate::plusYears, "-y", LocalDate::minusYears,
            "+q", (d, n) -> d.plus(Period.of(0, n.intValue() * 3, 0)),
            "-q", (d, n) -> d.minus(Period.of(0, n.intValue() * 3, 0))
    );
    private Runnable operation;

    public MoveDate(Context context) {
        super(context);
    }

    @Override
    public boolean test(String command) {
        final var plusMinus = PLUS_MINUS.matcher(command);
        final var isValidCommand = plusMinus.matches();

        if (isValidCommand) {
            final var sign = plusMinus.group(1);
            final var unit = plusMinus.group(3);
            final var number = Long.parseLong(plusMinus.group(2));
            LOGGER.log(TRACE, "sign = {0}, number = {1}, unit = {2}", sign, number, unit);
            operation = () -> setDate(MOVE_OPERATORS.get(sign + unit).apply(date(), number));
        }
        return isValidCommand;
    }

    @Override
    public void run() {
        operation.run();
    }

}
