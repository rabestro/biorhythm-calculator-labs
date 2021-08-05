package report.format;

import biorhytms.Biorhythm;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

public abstract class BiorhythmFormat extends Format {

    @Override
    public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos) {
        if (obj instanceof Biorhythm.Value) {
            return format((Biorhythm.Value) obj, toAppendTo, pos);
        }
        throw new IllegalArgumentException(
                "Cannot format given Object (" + obj.getClass().getName() + ") as a Biorhythm.Value");
    }

    @Override
    public Object parseObject(final String source, final ParsePosition pos) {
        throw new UnsupportedOperationException();
    }

    public abstract StringBuffer format(
            final Biorhythm.Value obj,
            final StringBuffer toAppendTo,
            final FieldPosition pos);
}
