package lv.id.jc.biorhythm.report;

import lv.id.jc.biorhythm.format.DaysFormat;
import lv.id.jc.biorhythm.format.MultilineTextFormat;
import lv.id.jc.biorhythm.format.OrdinalDateFormat;
import lv.id.jc.biorhythm.model.Biorhythm;
import lv.id.jc.biorhythm.model.Context;
import lv.id.jc.biorhythm.model.Indicator;
import lv.id.jc.biorhythm.command.AbstractCommand;

import java.text.Format;
import java.util.function.IntFunction;
import java.util.stream.Stream;

import static lv.id.jc.biorhythm.format.IndicatorTemplateFormat.DAILY;

public class SummaryReport extends AbstractCommand {
    private static final int LINE_MAXIMUM_WIDTH = 60;
    private static final Format DAYS_FORMAT = new DaysFormat();
    private static final Format ORDINAL_DATE_FORMAT = new OrdinalDateFormat();
    private static final Format MULTILINE_TEXT_FORMAT = new MultilineTextFormat(LINE_MAXIMUM_WIDTH);
    private final IntFunction<String> getDate = days -> ORDINAL_DATE_FORMAT.format(date().plusDays(days));

    public SummaryReport(final Context context) {
        super(context);
    }

    @Override
    public void run() {
        printf("summary.header.format");
        biorhythms().map(DAILY::format).forEach(this::println);
        biorhythms().forEach(this::printInfo);
        printf("summary.overall");
    }

    private Stream<Indicator> biorhythms() {
        return Biorhythm.primary().map(context::getIndicatorOf);
    }

    private void printInfo(Indicator value) {
        final var rhythm = value.getBiorhythm();
        final var text = format(getString(value.stage().name()),
                rhythm.name().toLowerCase(),
                rhythm.getAttributes(),
                getDate.apply(value.changeInDays()),
                DAYS_FORMAT.format(value.changeInDays()));

        printf("summary.biorhythm.name.format", rhythm);
        print(MULTILINE_TEXT_FORMAT.format(text));
        printf("summary.next.peak",
                rhythm.name().toLowerCase(),
                getDate.apply(value.peakInDays()),
                DAYS_FORMAT.format(value.peakInDays()));
        printf("summary.next.low",
                rhythm.name().toLowerCase(),
                getDate.apply(value.lowInDays()),
                DAYS_FORMAT.format(value.lowInDays()));
    }
}
