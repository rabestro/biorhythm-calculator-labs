package report.format;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

public class TextFormat extends Format {
    @Override
    public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos) {
        return null;
    }

    @Override
    public Object parseObject(final String source, final ParsePosition pos) {
        throw new UnsupportedOperationException();
    }
}
