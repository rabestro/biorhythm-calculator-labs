package lv.id.jc.biorhythm.format;

import org.jetbrains.annotations.NotNull;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Map;
import java.util.stream.LongStream;

import static java.time.temporal.ChronoField.*;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

/**
 * @deprecated in favour to DateFormatter class
 */
@Deprecated(forRemoval = true)
public class RomanDateFormat extends Format {
    private static final Map<Long, String> ROMAN;

    static {
        final var romanNumerals = new String[]{"",
                "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII"
        };
        ROMAN = LongStream.rangeClosed(1L, 12L)
                .boxed()
                .collect(toMap(identity(), month -> romanNumerals[month.intValue()]));
    }

    @Override
    public StringBuffer format(Object obj, @NotNull StringBuffer toAppendTo, @NotNull FieldPosition pos) {
        if (obj instanceof LocalDate) {
            return toAppendTo.append(format((LocalDate) obj));
        }
        if (obj instanceof MonthDay) {
            return toAppendTo.append(format((MonthDay) obj));
        }
        throw new IllegalArgumentException("Cannot format given Object (" + obj.getClass().getName() + ") as a LocalDate");
    }

    public String format(LocalDate obj) {
        return new DateTimeFormatterBuilder()
                .appendText(DAY_OF_MONTH)
                .appendLiteral('/')
                .appendText(MONTH_OF_YEAR, ROMAN)
                .appendLiteral('/')
                .appendText(YEAR)
                .toFormatter()
                .format(obj);
    }

    public String format(MonthDay obj) {
        return new DateTimeFormatterBuilder()
                .appendText(DAY_OF_MONTH)
                .appendLiteral('/')
                .appendText(MONTH_OF_YEAR, ROMAN)
                .toFormatter()
                .format(obj);
    }

    @Override
    public Object parseObject(String source, @NotNull ParsePosition pos) {
        throw new UnsupportedOperationException();
    }
}
