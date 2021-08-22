package lv.id.jc.biorhythm.report;

import lv.id.jc.biorhythm.command.AbstractCommand;
import lv.id.jc.biorhythm.model.Context;
import lv.id.jc.biorhythm.model.ZodiacSign;

import java.util.function.Supplier;

import static lv.id.jc.biorhythm.format.DateFormatter.ORDINAL_SHORT_DATE;

public class ZodiacInfo extends AbstractCommand implements Supplier<String> {

    public ZodiacInfo(Context context) {
        super(context);
    }

    @Override
    public void run() {
        print(get());
    }

    @Override
    public String get() {
        final var zodiacSign = birthday().query(ZodiacSign::from);
        final var output = new StringBuilder(format("zodiacSign.report",
                zodiacSign,
                zodiacSign.getSymbol(),
                ORDINAL_SHORT_DATE.format(zodiacSign.getStart()),
                ORDINAL_SHORT_DATE.format(zodiacSign.getEnd()),
                zodiacSign.getLuckyDay()));
        if (zodiacSign.isLuckyDay(date())) {
            output.append(format("zodiacSign.luckyDay", zodiacSign));
        }
        return output.toString();
    }
}
