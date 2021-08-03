package biorhytms.format;

import biorhytms.Biorhythm;
import lombok.val;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

public class SummaryFormat extends Format {

    @Override
    public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos) {
        if (!(obj instanceof Biorhythm.Value)) {
            throw new IllegalArgumentException("argument should be Biorhythm.Value");
        }
        val value = (Biorhythm.Value) obj;
        val biorhythm = value.getBiorhythm();
        val text = value
                .getStage()
                .getTemplate()
                .format(biorhythm.name().toLowerCase(),
                        biorhythm.getAttributes(),
                        value.cycleLastDay(),
                        value.changesInDays())
                .replaceAll("(.{1,60}) ", "$1\n");

        return toAppendTo
                .append(biorhythm.name())
                .append(':')
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .append(text)
                .append(System.lineSeparator());
    }

    @Override
    public Object parseObject(final String source, final ParsePosition pos) {
        return null;
    }
}
