package biorhytms.format;

import lombok.val;

import java.text.FieldPosition;
import java.util.regex.Pattern;

public class SummaryFormat extends BiorhythmFormat {
    private static final Pattern FIND_LINE_BREAK = Pattern.compile("(.{1,60}) ");
    private static final String INSERT_NEW_LINE = "$1\n";

    @Override
    public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos) {

        val value = getBiorhythmValue(obj);
        val args = new Object[]{
                value.getBiorhythm().name().toLowerCase(),
                value.getBiorhythm().getAttributes(),
                value.cycleLastDay(),
                value.changesInDays()
        };
        val text = value.getStage().getTemplate().format(args);

        return toAppendTo
                .append(value.getBiorhythm().name())
                .append(':')
                .append(System.lineSeparator())
                .append(System.lineSeparator())
                .append(FIND_LINE_BREAK.matcher(text).replaceAll(INSERT_NEW_LINE))
                .append(System.lineSeparator());
    }

}
