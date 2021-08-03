package biorhytms;

import biorhytms.format.DaysFormat;
import biorhytms.format.OrdinalDateFormat;
import lombok.Getter;

import java.text.Format;
import java.text.MessageFormat;
import java.util.Set;

@Getter
public enum Stage {
    ZERO("+",
            "Today is a critical day for your {0} attributes! " +
                    "That means it is an important day to focus on your {1}.",
            new Format[]{null, null}),
    POSITIVE_UP("»",
            "Your are progressing in a positive cycle for your {0} attributes, " +
                    "and this will last until {2} ({3}). Take advantage of your enhanced {1}!",
            new Format[]{null, new OrdinalDateFormat(), new DaysFormat(), null}),
    POSITIVE_DOWN("«",
            "Your are in a positive cycle for your {0} attributes, " +
                    "which ends on {2} ({3}). Take advantage of your enhanced {1} while they are at their peak.",
            new Format[]{null, new OrdinalDateFormat(), new DaysFormat(), null}),
    NEGATIVE_DOWN("«",
            "Your are in a negative cycle for your {0} attributes, which ends on {2} ({3}). " +
                    "Your {1} may not be at their highest, so it is a good opportunity to work on them!",
            new Format[]{null, new OrdinalDateFormat(), new DaysFormat(), null}),
    NEGATIVE_UP("»",
            "Your are in a negative {0} cycle, but it coming to an end " +
                    "on {2} ({3})! Work on improving your {1} as you near your next positive cycle!",
            new Format[]{null, new OrdinalDateFormat(), new DaysFormat(), null});

    private final String symbol;
    private final MessageFormat template;

    Stage(final String symbol, final String template, Format[] formats) {
        this.symbol = symbol;
        this.template = new MessageFormat(template);
        this.template.setFormats(formats);
    }

    public static Stage of(final int index) {
        return Stage.values()[index];
    }

    public MessageFormat getTemplate() {
        return template;
    }

    public boolean isUp() {
        return Set.of(POSITIVE_UP, NEGATIVE_UP).contains(this);
    }

    public boolean isPositive() {
        return Set.of(POSITIVE_UP, POSITIVE_DOWN).contains(this);
    }
}
