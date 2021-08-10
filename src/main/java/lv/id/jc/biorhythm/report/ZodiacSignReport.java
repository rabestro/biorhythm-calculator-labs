package lv.id.jc.biorhythm.report;

import lv.id.jc.biorhythm.Context;
import lv.id.jc.biorhythm.format.OrdinalDateFormat;
import lv.id.jc.biorhythm.model.ZodiacSign;
import lv.id.jc.biorhythm.ui.Component;

public class ZodiacSignReport extends Component {

    public ZodiacSignReport(Context context) {
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
