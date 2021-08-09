package lv.id.jc.biorhythm.report;

import lv.id.jc.biorhythm.Context;
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

    private static final DateTimeFormatter formatter;

    static {
        final Function<Long, String> ordinalDay = day -> MessageFormat
                .format("{0}{0,choice,1#st|2#nd|3#rd|3<th|21#st|22#nd|23#rd|23<th|31#st}", day);

        final var map = LongStream
                .rangeClosed(1L, 31L)
                .boxed()
                .collect(toMap(identity(), ordinalDay));

        formatter = new DateTimeFormatterBuilder()
                .append(DateTimeFormatter.ofPattern("MMM "))
                .appendText(DAY_OF_MONTH, map)
                .toFormatter();
    }

    public ZodiacSignReport(Context context) {
        super(context);
    }

    @Override
    public void run() {
        final var zodiacSign = ZodiacSign.of(birthday());

        printf("zodiacSign.report",
                zodiacSign,
                zodiacSign.getSymbol(),
                formatter.format(zodiacSign.getStart()),
                formatter.format(zodiacSign.getEnd()),
                zodiacSign.getLuckyDay());

        if (zodiacSign.getLuckyDay().equals(date().getDayOfWeek())) {
            printf("zodiacSign.luckyDay", zodiacSign.getLuckyDay(), zodiacSign.name());
        }
    }
}
