package biorhytms.format;

import java.time.LocalDate;

public class SummaryDateFormat extends AbstractFormat {
    private static final OrdinalDayFormat ORDINAL_DAY_FORMAT = new OrdinalDayFormat();

    @Override
    public String simpleFormat(final Object object) {
        final var date = (LocalDate) object;
        final var days = ORDINAL_DAY_FORMAT.format(object);
        return String.format("%tA, %<tb %2$s", date, days);
    }
}
