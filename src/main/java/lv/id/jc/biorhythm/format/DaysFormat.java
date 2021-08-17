package lv.id.jc.biorhythm.format;

import org.jetbrains.annotations.NotNull;

import java.text.FieldPosition;
import java.text.Format;
import java.text.MessageFormat;
import java.text.ParsePosition;

public class DaysFormat extends Format {
    private static final MessageFormat DAYS_FORMAT = new MessageFormat("{0, choice, 1#tomorrow|1<{0} days}");

    @Override
    public StringBuffer format(Object obj, @NotNull StringBuffer toAppendTo, @NotNull FieldPosition pos) {
        return toAppendTo.append(DAYS_FORMAT.format(new Object[]{obj}));
    }

    @Override
    public Object parseObject(String source, @NotNull ParsePosition pos) {
        throw new UnsupportedOperationException();
    }
}
