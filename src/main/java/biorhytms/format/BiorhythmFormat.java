package biorhytms.format;

import biorhytms.Biorhythm;

import java.text.Format;
import java.text.ParsePosition;

public abstract class BiorhythmFormat extends Format {

    protected Biorhythm.Value getBiorhythmValue(final Object obj) {
        if (obj instanceof Biorhythm.Value) {
            return (Biorhythm.Value) obj;
        }
        throw new IllegalArgumentException("argument should be Biorhythm.Value");
    }

    @Override
    public Object parseObject(final String source, final ParsePosition pos) {
        throw new UnsupportedOperationException();
    }
}
