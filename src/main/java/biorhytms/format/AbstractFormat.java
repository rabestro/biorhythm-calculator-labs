package biorhytms.format;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

public abstract class AbstractFormat extends Format {
    @Override
    public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos) {
        return toAppendTo.append(simpleFormat(obj));
    }

    @Override
    public Object parseObject(final String source, final ParsePosition pos) {
        return null;
    }

    public abstract String simpleFormat(Object object);
}
