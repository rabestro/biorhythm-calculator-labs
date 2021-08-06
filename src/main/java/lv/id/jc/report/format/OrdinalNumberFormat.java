package lv.id.jc.report.format;

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
        throw new UnsupportedOperationException();
    }

    @Override
    public Integer parseObject(final String source, final ParsePosition pos) {
        throw new UnsupportedOperationException();
    }
}
