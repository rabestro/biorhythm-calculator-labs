package tests;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

public class SummaryDateFormat extends Format {
    @Override
    public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos) {
        toAppendTo.append(String.format("%tA, %<tB %<te", obj));
        return toAppendTo;
    }

    @Override
    public Object parseObject(final String source, final ParsePosition pos) {
        return null;
    }
}
