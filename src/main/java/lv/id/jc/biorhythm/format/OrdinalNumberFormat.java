package lv.id.jc.biorhythm.format;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

public class OrdinalNumberFormat extends Format {

    @Override
    public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos) {
        if (obj instanceof Number) {
            return format((Number) obj, toAppendTo, pos);
        }
        throw new IllegalArgumentException(
                "Cannot format given Object (" + obj.getClass().getName() + ") as a Number");

    }

    public StringBuffer format(final Number obj, final StringBuffer toAppendTo, final FieldPosition pos) {
        final var lastTwo = obj.intValue() % 100;
        final var lastOne = lastTwo % 10;
        final var suffix = lastTwo > 3 && lastTwo < 21 ? "th"
                : lastOne == 1 ? "st"
                : lastOne == 2 ? "nd"
                : lastOne == 3 ? "rd"
                : "th";

        return toAppendTo.append(obj).append(suffix);
    }

    @Override
    public Integer parseObject(final String source, final ParsePosition pos) {
        throw new UnsupportedOperationException();
    }
}
