package lv.id.jc.biorhytm.report.format;

import lombok.val;

import java.text.FieldPosition;
import java.text.Format;
import java.text.MessageFormat;
import java.text.ParsePosition;
import java.time.Period;

public class PrettyPeriodFormat extends Format {
    private static final MessageFormat YEARS =
            new MessageFormat("{0, choice, 0#|1#one year|2#two years|2<{0} years}");
    private static final MessageFormat MONTHS =
            new MessageFormat("{0, choice, 0#|1#one month|2#two months|2<{0} months}");
    private static final MessageFormat DAYS =
            new MessageFormat("{0, choice, 0#|1#one day|2#two days|2<{0} days}");

    public static PrettyPeriodFormat getInstance() {
        return new PrettyPeriodFormat();
    }

    @Override
    public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos) {
        if (obj instanceof Period) {
            return format((Period) obj, toAppendTo, pos);
        }
        throw new IllegalArgumentException("Cannot format given Object (" + obj.getClass().getName() + ") as a Period");
    }

    public StringBuffer format(final Period period, final StringBuffer toAppendTo, final FieldPosition pos) {
        val years = YEARS.format(new Object[]{period.getYears()});
        val months = MONTHS.format(new Object[]{period.getMonths()});
        val days = DAYS.format(new Object[]{period.getDays()});

        if ((years + months + days).isEmpty()) {
            return toAppendTo.append("just born");
        }

        val one = years.isEmpty() || (months.isEmpty() && days.isEmpty())
                ? "" : months.isEmpty() || days.isEmpty() ? " and " : ", ";
        val two = days.isEmpty() || months.isEmpty() ? "" : " and ";

        return toAppendTo
                .append(years)
                .append(one)
                .append(months)
                .append(two)
                .append(days);
    }

    @Override
    public Object parseObject(final String source, final ParsePosition pos) {
        throw new UnsupportedOperationException();
    }
}
