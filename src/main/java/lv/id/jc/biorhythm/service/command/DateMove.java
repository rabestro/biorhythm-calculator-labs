package lv.id.jc.biorhythm.service.command;

import lv.id.jc.biorhythm.ui.Component;

import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.regex.Pattern;

import static java.lang.System.Logger.Level.TRACE;

public class DateMove implements Command {
    private static final Pattern PLUS_MINUS = Pattern.compile("([-+])(\\d+)([dwmyq])");
    private static final Map<String, BiFunction<LocalDate, Long, LocalDate>> MOVE_OPERATORS = Map.of(
            "+d", LocalDate::plusDays, "-d", LocalDate::minusDays,
            "+w", LocalDate::plusWeeks, "-w", LocalDate::minusWeeks,
            "+m", LocalDate::plusMonths, "-m", LocalDate::minusMonths,
            "+y", LocalDate::plusYears, "-y", LocalDate::minusYears,
            "+q", (d, n) -> d.plus(Period.of(0, n.intValue() * 3, 0)),
            "-q", (d, n) -> d.minus(Period.of(0, n.intValue() * 3, 0))
    );

    @Override
    public Optional<Runnable> process(String command, Component processor) {
        final var plusMinus = PLUS_MINUS.matcher(command);
        if (!plusMinus.matches()) {
            return Optional.empty();
        }
        final var sign = plusMinus.group(1);
        final var number = Long.parseLong(plusMinus.group(2));
        final var unit = plusMinus.group(3);
        processor.LOGGER.log(TRACE, "sign = {0}, number = {1}, unit = {2}", sign, number, unit);
        final var op = MOVE_OPERATORS.get(sign + unit);
        return Optional.of(
                () -> processor.setDate(op.apply(processor.date(), number)));
    }
}
