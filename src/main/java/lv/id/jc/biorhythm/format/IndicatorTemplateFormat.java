package lv.id.jc.biorhythm.format;

import lv.id.jc.biorhythm.model.Indicator;
import org.jetbrains.annotations.NotNull;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

public class IndicatorTemplateFormat extends Format {
    private final String template;

    public IndicatorTemplateFormat(String template) {
        this.template = template;
    }

    @Override
    public StringBuffer format(Object obj, @NotNull StringBuffer toAppendTo, @NotNull FieldPosition pos) {
        if (obj instanceof Indicator) {
            return toAppendTo.append(format((Indicator) obj));
        }
        throw new IllegalArgumentException(
                "Cannot format given Object (" + obj.getClass().getName() + ") as an Indicator");
    }

    public String format(final Indicator indicator) {
        return String.format(template,
                indicator.getBiorhythm(),
                indicator.getValue());
    }

    @Override
    public Indicator parseObject(String source, @NotNull ParsePosition pos) {
        throw new UnsupportedOperationException();
    }
}
