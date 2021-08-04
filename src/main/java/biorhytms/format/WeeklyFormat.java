package biorhytms.format;

import biorhytms.Biorhythm;

import java.text.FieldPosition;

public class WeeklyFormat extends BiorhythmFormat {
    private final String template;

    public WeeklyFormat() {
        this("%-12s %4d %%");
    }

    public WeeklyFormat(final String template) {
        super();
        this.template = template;
    }

    @Override
    public StringBuffer format(final Biorhythm.Value obj, final StringBuffer toAppendTo, final FieldPosition pos) {
        return toAppendTo.append(String.format(template, obj.getBiorhythm().name(), obj.getPercent()));
    }
}
