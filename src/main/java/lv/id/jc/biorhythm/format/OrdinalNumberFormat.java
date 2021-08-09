package lv.id.jc.biorhythm.format;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

public class OrdinalNumberFormat extends Format {
    private static final String[] SUFFIX = new String[]{"th", "st", "nd", "rd"};

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
        final var index = lastTwo > 3 && lastTwo < 21 || lastOne > 3 ? 0 : lastOne;
        return toAppendTo.append(obj).append(SUFFIX[index]);
    }

    @Override
    public Integer parseObject(final String source, final ParsePosition pos) {
        throw new UnsupportedOperationException();
    }
}
