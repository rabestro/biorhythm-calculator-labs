package biorhytms.format;

import biorhytms.Biorhythm;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.util.Formatter;

public class DailyFormat extends BiorhythmFormat {
    private static final Formatter formatter = new Formatter();

    @Override
    public StringBuffer format(final Biorhythm.Value value, final StringBuffer toAppendTo, final FieldPosition pos) {
        return (StringBuffer) new Formatter(toAppendTo)
                .format("%12s: %s",
                        value.getBiorhythm().name(),
                        NumberFormat.getPercentInstance().format(value.getValue()))
                .out();
    }
}
