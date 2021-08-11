package lv.id.jc.biorhythm.format;

import org.jetbrains.annotations.NotNull;

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
    @SuppressWarnings("rawtypes")
    public StringBuffer format(final Object obj, final @NotNull StringBuffer toAppendTo, final @NotNull FieldPosition pos) {
        if (obj instanceof Collection) {
            return toAppendTo.append(format((Collection) obj));
        }
        throw new IllegalArgumentException("Cannot format given Object (" + obj.getClass().getName() + ") as a Collection");
    }

    @SuppressWarnings("unchecked")
    public String format(@SuppressWarnings("rawtypes") final Collection obj) {
        final var text = obj.stream()
                .filter(Objects::nonNull)
                .map(Objects::toString)
                .filter(Predicate.not(String::isBlank))
                .collect(Collectors.joining(", "))
                .toString();

        return LAST_COMMA.matcher(text).replaceFirst(LAST_AND);
    }

    @Override
    public Object parseObject(final String source, final @NotNull ParsePosition pos) {
        throw new UnsupportedOperationException();
    }
}
