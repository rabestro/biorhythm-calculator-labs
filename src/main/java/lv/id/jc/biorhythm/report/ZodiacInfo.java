package lv.id.jc.biorhythm.report;

import lv.id.jc.biorhythm.command.AbstractCommand;
import lv.id.jc.biorhythm.format.OrdinalDateFormat;
import lv.id.jc.biorhythm.model.Context;
import lv.id.jc.biorhythm.model.ZodiacSign;

public class ZodiacInfo extends AbstractCommand {

    public ZodiacInfo(Context context) {
        super(context);
    }

    @Override
    public void run() {
        final var zodiacSign = ZodiacSign.of(birthday());
        final var formatter = new OrdinalDateFormat();

        printf("zodiacSign.report",
                zodiacSign,
                zodiacSign.getSymbol(),
                formatter.format(zodiacSign.getStart()),
                formatter.format(zodiacSign.getEnd()),
                zodiacSign.getLuckyDay());

        if (zodiacSign.getLuckyDay().equals(date().getDayOfWeek())) {
            printf("zodiacSign.luckyDay", zodiacSign.getLuckyDay(), zodiacSign);
        }
    }

}
