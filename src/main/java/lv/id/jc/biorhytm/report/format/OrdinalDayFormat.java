package lv.id.jc.biorhytm.report.format;

import java.text.MessageFormat;
import java.time.LocalDate;

public class OrdinalDayFormat extends AbstractFormat {
    private static final MessageFormat ORDINAL_DAY =
            new MessageFormat("{0}{0,choice,1#st|2#nd|3#rd|3<th|21#st|22#nd|23#rd|23<th|31#st}");

    @Override
    public String simpleFormat(final Object obj) {
        if (obj instanceof LocalDate) {
            final var date = (LocalDate) obj;
            return ORDINAL_DAY.format(new Object[]{date.getDayOfMonth()});
        }
        if (obj instanceof Number) {
            return ORDINAL_DAY.format(new Object[]{obj});
        }

        throw new IllegalArgumentException(
                "Cannot format given Object (" + obj.getClass().getName() + ") as a LocalDate or Number");
    }
}
