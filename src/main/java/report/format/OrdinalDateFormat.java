package report.format;

import java.text.Format;
import java.time.LocalDate;

public class OrdinalDateFormat extends AbstractFormat {

    public OrdinalDateFormat() {
        this(new OrdinalDayFormat());
    }

    public OrdinalDateFormat(final Format ordinalDay) {
        this.ordinalDay = ordinalDay;
    }

    private final Format ordinalDay;

    @Override
    public String simpleFormat(final Object object) {
        if (object instanceof LocalDate) {
            final var date = (LocalDate) object;
            final var days = ordinalDay.format(date.getDayOfMonth());
            return String.format("%tA, %<tB %2$s", date, days);

        }
        throw new IllegalArgumentException("expected LocalDate, actual is " + object.getClass().getName());
    }
}
