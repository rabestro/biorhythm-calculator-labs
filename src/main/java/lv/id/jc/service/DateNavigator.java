package lv.id.jc.service;

import lombok.val;
import lv.id.jc.report.Context;
import lv.id.jc.ui.LocalTextInterface;

import java.time.LocalDate;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.regex.Pattern;

import static java.lang.System.Logger.Level.TRACE;

public class DateNavigator extends LocalTextInterface implements Runnable {
    private static final Pattern PLUS_MINUS = Pattern.compile("([-+])(\\d+)([dwmy])");
    private static final Map<String, BiFunction<LocalDate, Long, LocalDate>> operatorMap = Map.of(
            "+d", LocalDate::plusDays, "-d", LocalDate::minusDays,
            "+w", LocalDate::plusWeeks, "-w", LocalDate::minusDays,
            "+m", LocalDate::plusMonths, "-m", LocalDate::minusMonths,
            "+y", LocalDate::plusYears, "-y", LocalDate::minusYears
    );

    private final Context context;

    public DateNavigator(final Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        while (true) {
            printf("prompt", context.date());
            val command = scanner.nextLine().toLowerCase();
            if ("exit".equals(command) || "quit".equals(command)) {
                return;
            }
            val plusMinus = PLUS_MINUS.matcher(command);
            if (plusMinus.matches()) {
                val sign = plusMinus.group(1);
                val number = Long.parseLong(plusMinus.group(2));
                val unit = plusMinus.group(3);
                LOGGER.log(TRACE, "sign = {0}, number = {1}, unit = {2}", sign, number, unit);
                context.setDate(operatorMap.get(sign + unit).apply(context.date(), number));
            }
        }
    }
}
