package lv.id.jc.biorhythm.format;

import org.jetbrains.annotations.NotNull;

import java.text.FieldPosition;
import java.text.Format;
import java.text.MessageFormat;
import java.text.ParsePosition;
import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.LongStream;

import static java.time.format.TextStyle.FULL;
import static java.time.temporal.ChronoField.*;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public class OrdinalDateFormat extends Format {
    private static final Map<Long, String> ORDINAL;

    static {
        final Function<Long, String> ordinalDay = day -> MessageFormat
                .format("{0}{0,choice,1#st|2#nd|3#rd|3<th|21#st|22#nd|23#rd|23<th|31#st}", day);
        ORDINAL = LongStream.rangeClosed(1L, 31L).boxed().collect(toMap(identity(), ordinalDay));
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
                .appendText(DAY_OF_WEEK, FULL)
                .appendLiteral(", ")
                .appendText(MONTH_OF_YEAR, FULL)
                .appendLiteral(' ')
                .appendText(DAY_OF_MONTH, ORDINAL)
                .toFormatter()
                .format(obj);
    }

    public String format(MonthDay obj) {
        return new DateTimeFormatterBuilder()
                .appendText(MONTH_OF_YEAR, FULL)
                .appendLiteral(' ')
                .appendText(DAY_OF_MONTH, ORDINAL)
                .toFormatter()
                .format(obj);
    }

    @Override
    public Object parseObject(String source, @NotNull ParsePosition pos) {
        throw new UnsupportedOperationException();
    }

}
