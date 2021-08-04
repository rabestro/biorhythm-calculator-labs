package biorhytms.format;

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
        if (!(obj instanceof Collection)) {
            throw new IllegalArgumentException("argument should be a Collection");
        }
        val collection = (Collection) obj;
        val text = collection.stream()
                .filter(Objects::nonNull)
                .map(Objects::toString)
                .filter(Predicate.not(String::isBlank))
                .collect(Collectors.joining(", "))
                .toString();

        return toAppendTo.append(LAST_COMMA.matcher(text).replaceFirst(LAST_AND));
    }

    @Override
    public Object parseObject(final String source, final ParsePosition pos) {
        return null;
    }
}
