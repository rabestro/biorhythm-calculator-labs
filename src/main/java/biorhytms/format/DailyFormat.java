package biorhytms.format;

import biorhytms.Biorhythm;

import java.text.FieldPosition;

public class DailyFormat extends BiorhythmFormat {

    private final String template = "%-12s %4d %%";

    @Override
    public StringBuffer format(final Biorhythm.Value obj, final StringBuffer toAppendTo, final FieldPosition pos) {
        return toAppendTo.append(String.format(template, obj.getBiorhythm().name(), obj.getPercent()));

    }
}
