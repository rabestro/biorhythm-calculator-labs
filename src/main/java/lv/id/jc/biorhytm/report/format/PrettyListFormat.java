package lv.id.jc.biorhytm.report.format;

import lombok.val;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class PrettyListFormat extends Format {
    private static final Pattern LAST_COMMA = Pattern.compile("(.*),");
    private static final String LAST_AND = "$1 and";

    @Override
    public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos) {
        if (obj instanceof Collection) {
            return format((Collection) obj, toAppendTo, pos);
        }
        throw new IllegalArgumentException("Cannot format given Object (" + obj.getClass().getName() + ") as a Collection");
    }

    public StringBuffer format(final Collection obj, final StringBuffer toAppendTo, final FieldPosition pos) {
        val text = obj.stream()
                .filter(Objects::nonNull)
                .map(Objects::toString)
                .filter(Predicate.not(String::isBlank))
                .collect(Collectors.joining(", "))
                .toString();

        return toAppendTo.append(LAST_COMMA.matcher(text).replaceFirst(LAST_AND));
    }

    @Override
    public Object parseObject(final String source, final ParsePosition pos) {
        throw new UnsupportedOperationException();
    }
}
