package lv.id.jc.biorhythm.format;

import org.jetbrains.annotations.NotNull;

import java.text.FieldPosition;
import java.text.Format;
import java.text.MessageFormat;
import java.text.ParsePosition;

public class OrdinalNumberFormat extends Format {
    private static final MessageFormat ORDINAL_NUMBER =
            new MessageFormat("{0}{0,choice,1#st|2#nd|3#rd|3<th|21#st|22#nd|23#rd|23<th|31#st}");

    @Override
    public StringBuffer format(final Object obj, @NotNull final StringBuffer toAppendTo, @NotNull final FieldPosition pos) {
        if (obj instanceof Number) {
            return format((Number) obj, toAppendTo, pos);
        }
        throw new IllegalArgumentException(
                "Cannot format given Object (" + obj.getClass().getName() + ") as a Number");

    }

    public StringBuffer format(final Number obj, final StringBuffer toAppendTo, final FieldPosition pos) {
        return toAppendTo.append(ORDINAL_NUMBER.format(new Object[]{obj}));
    }

    @Override
    public Integer parseObject(final String source, @NotNull final ParsePosition pos) {
        throw new UnsupportedOperationException();
    }
}
