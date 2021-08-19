package lv.id.jc.biorhythm.report;

import lv.id.jc.biorhythm.command.AbstractCommand;
import lv.id.jc.biorhythm.model.Context;
import lv.id.jc.biorhythm.model.ZodiacSign;

import static lv.id.jc.biorhythm.format.DateFormatter.ORDINAL_SHORT_DATE;

public class ZodiacInfo extends AbstractCommand {

    public ZodiacInfo(Context context) {
        super(context);
    }

    @Override
    public void run() {
        final var zodiacSign = ZodiacSign.of(birthday());

        printf("zodiacSign.report",
                zodiacSign,
                zodiacSign.getSymbol(),
                ORDINAL_SHORT_DATE.format(zodiacSign.getStart()),
                ORDINAL_SHORT_DATE.format(zodiacSign.getEnd()),
                zodiacSign.getLuckyDay());

        if (zodiacSign.getLuckyDay().equals(date().getDayOfWeek())) {
            printf("zodiacSign.luckyDay", zodiacSign.getLuckyDay(), zodiacSign);
        }
    }

}
