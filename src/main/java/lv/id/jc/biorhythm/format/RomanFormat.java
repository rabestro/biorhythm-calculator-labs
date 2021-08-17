package lv.id.jc.biorhythm.format;

import org.jetbrains.annotations.NotNull;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

public class RomanFormat extends Format {
    @Override
    public StringBuffer format(Object obj, @NotNull StringBuffer toAppendTo, @NotNull FieldPosition pos) {
        if (obj instanceof Number) {
            return format((Number) obj, toAppendTo);
        }
        throw new IllegalArgumentException(
                "Cannot format given Object (" + obj.getClass().getName() + ") as a Number");
    }

    @SuppressWarnings("squid:S1149")
    public StringBuffer format(final Number obj, final StringBuffer toAppendTo) {
        int number = obj.intValue();
        for (var romanNumeral : RomanNumerals.values()) {
            while (romanNumeral.value <= number) {
                number -= romanNumeral.value;
                toAppendTo.append(romanNumeral);
            }
        }
        return toAppendTo;
    }

    @Override
    public Object parseObject(String source, @NotNull ParsePosition pos) {
        throw new UnsupportedOperationException();
    }

    private enum RomanNumerals {
        M(1000), CM(900), D(500), CD(400), C(100), XC(90),
        L(50), XL(40), X(10), IX(9), V(5), IV(4), I(1);

        final int value;

        RomanNumerals(final int value) {
            this.value = value;
        }
    }

}
