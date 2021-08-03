package biorhytms.format;

import java.time.LocalDate;

public class OrdinalDateFormat extends AbstractFormat {
    private static final OrdinalDayFormat ORDINAL_DAY_FORMAT = new OrdinalDayFormat();

    @Override
    public String simpleFormat(final Object object) {
        if (object instanceof LocalDate) {
            final var date = (LocalDate) object;
            final var days = ORDINAL_DAY_FORMAT.format(date.getDayOfMonth());
            return String.format("%tA, %<tb %2$s", date, days);

        }
        throw new IllegalArgumentException("expected LocalDate, actual is " + object.getClass().getName());
    }
}
