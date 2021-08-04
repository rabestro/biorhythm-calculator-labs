package biorhytms.format;

import biorhytms.Biorhythm;

import java.text.FieldPosition;

public class WeeklyFormat extends BiorhythmFormat {
    @Override
    public StringBuffer format(final Biorhythm.Value obj, final StringBuffer toAppendTo, final FieldPosition pos) {
        return toAppendTo.append(
                String.format("%-12s %4d %%", obj.getBiorhythm().name(), obj.getPercent())
        );
    }
}
