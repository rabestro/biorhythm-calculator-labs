package lv.id.jc.biorhythm.format;

import lv.id.jc.biorhythm.model.Indicator;
import org.jetbrains.annotations.NotNull;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;

public class IndicatorTemplateFormat extends Format {
    public static final Format DAILY = new IndicatorTemplateFormat("%1$-12s %2$4d%%");
    public static final Format WEEKLY = new IndicatorTemplateFormat("%1$-12s %2$4d %%");
    private final String template;

    public IndicatorTemplateFormat(String template) {
        this.template = template;
    }

    public String format(final Indicator indicator) {
        return String.format(template,
                indicator.getBiorhythm(),
                indicator.percent(),
                indicator.value(),
                indicator.dayInPeriod(),
                indicator.changeInDays(),
                indicator.peakInDays(),
                indicator.lowInDays(),
                indicator.stage()
        );
    }

    @Override
    public StringBuffer format(Object obj, @NotNull StringBuffer toAppendTo, @NotNull FieldPosition pos) {
        if (obj instanceof Indicator) {
            return toAppendTo.append(format((Indicator) obj));
        }
        throw new IllegalArgumentException(
                "Cannot format given Object (" + obj.getClass().getName() + ") as an Indicator");
    }

    @Override
    public Indicator parseObject(String source, @NotNull ParsePosition pos) {
        throw new UnsupportedOperationException();
    }
}
