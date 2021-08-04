package biorhytms.format;

import lombok.val;

import java.text.FieldPosition;
import java.text.Format;
import java.text.MessageFormat;
import java.text.ParsePosition;
import java.time.Period;

public class PrettyPeriodFormat extends Format {
    @Override
    public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos) {
        if (!(obj instanceof Period)) {
            throw new IllegalArgumentException("argument should be Period");
        }
        val period = (Period) obj;
        val years = MessageFormat.format(
                "{0, choice, 0#|1#one year|2#two years|2<{0} years}", period.getYears());
        val months = MessageFormat.format(
                "{0, choice, 0#|1#one month|2#two months|2<{0} months}", period.getMonths());
        val days = MessageFormat.format(
                "{0, choice, 0#|1#one day|2#two days|2<{0} days}", period.getDays());

        if ((years + months + days).isEmpty()) {
            return toAppendTo.append("just born");
        }

        val one = years.isEmpty() || (months.isEmpty() && days.isEmpty())
                ? "" : months.isEmpty() || days.isEmpty() ? " and " : ", ";

        val two = days.isEmpty() || months.isEmpty() ? "" : " and ";

        return toAppendTo.append(years + one + months + two + days);
    }

    @Override
    public Object parseObject(final String source, final ParsePosition pos) {
        return null;
    }
}
