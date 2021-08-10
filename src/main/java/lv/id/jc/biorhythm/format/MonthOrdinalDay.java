package lv.id.jc.biorhythm.format;

import org.jetbrains.annotations.NotNull;

import java.text.FieldPosition;
import java.text.Format;
import java.text.MessageFormat;
import java.text.ParsePosition;
import java.time.LocalDate;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.LongStream;

import static java.time.format.TextStyle.FULL;
import static java.time.temporal.ChronoField.*;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public class MonthOrdinalDay extends Format {
    private static final Map<Long, String> ORDINAL;

    static {
        final Function<Long, String> ordinalDay = day -> MessageFormat
                .format("{0}{0,choice,1#st|2#nd|3#rd|3<th|21#st|22#nd|23#rd|23<th|31#st}", day);
        ORDINAL = LongStream.rangeClosed(1L, 31L).boxed().collect(toMap(identity(), ordinalDay));
    }

    /**
     * Formats an object and appends the resulting text to a given string
     * buffer.
     * If the <code>pos</code> argument identifies a field used by the format,
     * then its indices are set to the beginning and end of the first such
     * field encountered.
     *
     * @param obj        The object to format
     * @param toAppendTo where the text is to be appended
     * @param pos        A <code>FieldPosition</code> identifying a field
     *                   in the formatted text
     * @return the string buffer passed in as <code>toAppendTo</code>,
     * with formatted text appended
     * @throws NullPointerException     if <code>toAppendTo</code> or
     *                                  <code>pos</code> is null
     * @throws IllegalArgumentException if the Format cannot format the given
     *                                  object
     */
    @Override
    public StringBuffer format(Object obj, @NotNull StringBuffer toAppendTo, @NotNull FieldPosition pos) {
        if (obj instanceof LocalDate) {
            return format((LocalDate) obj, toAppendTo, pos);
        }
        throw new IllegalArgumentException("Cannot format given Object (" + obj.getClass().getName() + ") as a LocalDate");
    }

    public StringBuffer format(LocalDate obj, @NotNull StringBuffer toAppendTo, @NotNull FieldPosition pos) {
        final var formatter = new DateTimeFormatterBuilder()
                .appendText(DAY_OF_WEEK, FULL)
                .appendLiteral(", ")
                .appendText(MONTH_OF_YEAR, FULL)
                .appendLiteral(' ')
                .appendText(DAY_OF_MONTH, ORDINAL)
                .toFormatter();

        return toAppendTo.append(formatter.format(obj));
    }

    /**
     * Parses text from a string to produce an object.
     * <p>
     * The method attempts to parse text starting at the index given by
     * <code>pos</code>.
     * If parsing succeeds, then the index of <code>pos</code> is updated
     * to the index after the last character used (parsing does not necessarily
     * use all characters up to the end of the string), and the parsed
     * object is returned. The updated <code>pos</code> can be used to
     * indicate the starting point for the next call to this method.
     * If an error occurs, then the index of <code>pos</code> is not
     * changed, the error index of <code>pos</code> is set to the index of
     * the character where the error occurred, and null is returned.
     *
     * @param source A <code>String</code>, part of which should be parsed.
     * @param pos    A <code>ParsePosition</code> object with index and error
     *               index information as described above.
     * @return An <code>Object</code> parsed from the string. In case of
     * error, returns null.
     * @throws NullPointerException if {@code source} or {@code pos} is null.
     */
    @Override
    public Object parseObject(String source, @NotNull ParsePosition pos) {
        throw new UnsupportedOperationException();
    }

}
