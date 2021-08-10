package lv.id.jc.biorhythm.report;

import lv.id.jc.biorhythm.Context;
import lv.id.jc.biorhythm.format.MonthOrdinalDay;
import lv.id.jc.biorhythm.model.ZodiacSign;
import lv.id.jc.biorhythm.ui.Component;

import java.text.MessageFormat;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.function.Function;
import java.util.stream.LongStream;

import static java.time.temporal.ChronoField.DAY_OF_MONTH;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public class ZodiacSignReport extends Component {

    public ZodiacSignReport(Context context) {
        super(context);
    }

    @Override
    public void run() {
        final var zodiacSign = ZodiacSign.of(birthday());
        final var formatter = new MonthOrdinalDay();

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
