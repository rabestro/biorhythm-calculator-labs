package lv.id.jc.biorhythm.format;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Map;

import static java.time.temporal.ChronoField.*;
import static java.util.Map.entry;

public abstract class DateFormatter {
    public static final Map<Long, String> ROMAN_MONTHS = Map.ofEntries(
            entry(1L, "I"), entry(2L, "II"), entry(3L, "III"),
            entry(4L, "IV"), entry(5L, "V"), entry(6L, "VI"),
            entry(7L, "VII"), entry(8L, "VIII"), entry(9L, "IX"),
            entry(10L, "X"), entry(11L, "XI"), entry(12L, "XII")
    );

    public static final DateTimeFormatter ROMAN_FULL =
            new DateTimeFormatterBuilder()
                    .appendText(DAY_OF_MONTH)
                    .appendLiteral('/')
                    .appendText(MONTH_OF_YEAR, ROMAN_MONTHS)
                    .appendLiteral('/')
                    .appendText(YEAR)
                    .toFormatter();

    public static final DateTimeFormatter ROMAN_SHORT =
            new DateTimeFormatterBuilder()
                    .appendText(DAY_OF_MONTH)
                    .appendLiteral('/')
                    .appendText(MONTH_OF_YEAR, ROMAN_MONTHS)
                    .toFormatter();

}
