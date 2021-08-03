package biorhytms.format;

import java.text.MessageFormat;
import java.time.LocalDate;

public class OrdinalDayFormat extends AbstractFormat {
    private static final MessageFormat ORDINAL_DAY =
            new MessageFormat("{0}{0,choice,1#st|2#nd|3#rd|3<th|21#st|22#nd|23#rd|23<th|31#st}");

    @Override
    public String simpleFormat(final Object object) {
        if (object instanceof LocalDate) {
            final var date = (LocalDate) object;
            return ORDINAL_DAY.format(new Object[]{date.getDayOfMonth()});
        }
        if (object instanceof Number) {
            return ORDINAL_DAY.format(new Object[]{object});
        }

        throw new IllegalArgumentException();
    }
}
