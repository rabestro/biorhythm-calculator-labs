package lv.id.jc.biorhythm.format;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.Objects;
import java.util.regex.Pattern;

public class MultilineTextFormat extends Format {
    public static final int DEFAULT_WIDTH = 60;
    public static final int MAXIMUM_WIDTH = 120;

    private static final Pattern LINEBREAK = Pattern.compile("\\R");
    private static final String SPACE = " ";

    private final Pattern pattern;
    private final String template;

    public MultilineTextFormat() {
        this(DEFAULT_WIDTH);
    }

    public MultilineTextFormat(final int width) {
        Objects.checkIndex(width, MAXIMUM_WIDTH);
        pattern = Pattern.compile("(.{2," + width + "})(\\s|$)");
        template = "$1\n";
    }

    @Override
    public StringBuffer format(final Object obj, final StringBuffer toAppendTo, final FieldPosition pos) {
        return toAppendTo.append(pattern.matcher(obj.toString()).replaceAll(template));
    }

    @Override
    public Object parseObject(final String source, final ParsePosition pos) {
        pos.setIndex(pos.getIndex() + source.length());
        return LINEBREAK.matcher(source).replaceAll(SPACE).stripTrailing();
    }
}
