package lv.id.jc.biorhythm.format;

import java.text.MessageFormat;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Map;
import java.util.function.LongFunction;
import java.util.stream.LongStream;

import static java.time.format.TextStyle.FULL;
import static java.time.temporal.ChronoField.*;
import static java.util.Map.entry;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toUnmodifiableMap;

public abstract class DateFormatter {
    public static final Period FORTNIGHT = Period.ofWeeks(2);
    public static final LongFunction<String> ordinalDay = day -> MessageFormat
            .format("{0}{0,choice,1#st|2#nd|3#rd|3<th|21#st|22#nd|23#rd|23<th|31#st}", day);
    private static final Map<Long, String> ORDINAL_DAYS = LongStream.rangeClosed(1L, 31L).boxed()
            .collect(toUnmodifiableMap(identity(), ordinalDay::apply));

    public static final Map<Long, String> ROMAN_MONTHS = Map.ofEntries(
            entry(1L, "I"), entry(2L, "II"), entry(3L, "III"),
            entry(4L, "IV"), entry(5L, "V"), entry(6L, "VI"),
            entry(7L, "VII"), entry(8L, "VIII"), entry(9L, "IX"),
            entry(10L, "X"), entry(11L, "XI"), entry(12L, "XII")
    );
    public static final DateTimeFormatter ROMAN_FULL_DATE =
            new DateTimeFormatterBuilder()
                    .appendText(DAY_OF_MONTH)
                    .appendLiteral('/')
                    .appendText(MONTH_OF_YEAR, ROMAN_MONTHS)
                    .appendLiteral('/')
                    .appendText(YEAR)
                    .toFormatter();

    public static final DateTimeFormatter ROMAN_SHORT_DATE =
            new DateTimeFormatterBuilder()
                    .appendText(DAY_OF_MONTH)
                    .appendLiteral('/')
                    .appendText(MONTH_OF_YEAR, ROMAN_MONTHS)
                    .toFormatter();

    public static final DateTimeFormatter ORDINAL_FULL_DATE =
            new DateTimeFormatterBuilder()
                    .appendText(DAY_OF_WEEK, FULL)
                    .appendLiteral(", ")
                    .appendText(MONTH_OF_YEAR, FULL)
                    .appendLiteral(' ')
                    .appendText(DAY_OF_MONTH, ORDINAL_DAYS)
                    .toFormatter();

    public static final DateTimeFormatter ORDINAL_SHORT_DATE =
            new DateTimeFormatterBuilder()
                    .appendText(MONTH_OF_YEAR, FULL)
                    .appendLiteral(' ')
                    .appendText(DAY_OF_MONTH, ORDINAL_DAYS)
                    .toFormatter();

    /**
     * Private constructor since this is a utility class.
     */
    private DateFormatter() {
    }

}
