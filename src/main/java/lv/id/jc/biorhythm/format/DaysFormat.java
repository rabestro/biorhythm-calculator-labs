package lv.id.jc.biorhythm.format;

import java.text.MessageFormat;

public class DaysFormat extends AbstractFormat {
    private static final MessageFormat DAYS_FORMAT =
            new MessageFormat("{0, choice, 1#tomorrow|1<{0} days}");

    @Override
    public String simpleFormat(final Object object) {
        return DAYS_FORMAT.format(new Object[]{object});
    }
}
