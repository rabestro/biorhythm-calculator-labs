package lv.id.jc.biorhythm.format;

import lv.id.jc.biorhythm.model.Biorhythm;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

public class BiorhythmFormat extends Format {
    private final String template;

    public BiorhythmFormat(final String template) {
        this.template = template;
    }

    @Override
    public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos) {
        if (obj instanceof Biorhythm.Value) {
            return format((Biorhythm.Value) obj, toAppendTo, pos);
        }
        throw new IllegalArgumentException(
                "Cannot format given Object (" + obj.getClass().getName() + ") as a Biorhythm.Value");
    }

    @Override
    public Biorhythm.Value parseObject(final String source, final ParsePosition pos) {
        throw new UnsupportedOperationException();
    }

    public StringBuffer format(final Biorhythm.Value value, final StringBuffer toAppendTo, final FieldPosition pos) {
        return toAppendTo.append(String.format(
                template,
                value.getBiorhythm().name(),
                value.getPercent()));
    }

}
