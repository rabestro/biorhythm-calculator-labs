package lv.id.jc.biorhythm.report;

import lv.id.jc.biorhythm.model.Biorhythm;
import lv.id.jc.biorhythm.model.Condition;
import lv.id.jc.biorhythm.model.Context;
import lv.id.jc.biorhythm.model.Indicator;
import lv.id.jc.biorhythm.command.AbstractCommand;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Locale;

import static java.util.stream.Collectors.joining;

public class AnnualReport extends AbstractCommand {
    public AnnualReport(final Context context) {
        super(context);
    }

    @Override
    public void run() {
        final var leftPart = format("annual.header.left.format", birthday());
        final var rightPart = format("annual.header.right.format", date());

        printf("annual.header.format", leftPart, rightPart);

        final var months = Arrays.stream(Month.values())
                .map(m -> m.getDisplayName(TextStyle.SHORT, Locale.getDefault()))
                .toArray();
        printf("annual.months.format", months);


        for (int day = 1; day < 32; day++) {
            printf("%3d   ", day);
            for (int month = 1; month < 13; month++) {
                printf("%-6s", dayConditions(month, day));
            }
            println();
        }
    }

    private String dayConditions(final int month, final int day) {
        try {
            final var dayDate = LocalDate.of(context.getYear(), month, day);
            final var dayContext = new Context(birthday(), dayDate);

            return Biorhythm.primary()
                    .map(dayContext::getIndicatorOf)
                    .map(Indicator::value)
                    .map(Condition::of)
                    .map(Condition::name)
                    .map(String::toLowerCase)
                    .map("condition."::concat)
                    .map(this::getProperty)
                    .collect(joining());

        } catch (DateTimeException e) {
            return "";
        }
    }

}
