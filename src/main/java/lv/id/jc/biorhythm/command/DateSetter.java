package lv.id.jc.biorhythm.command;

import lv.id.jc.biorhythm.model.Context;

import java.time.LocalDate;
import java.util.Map;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;
import static java.util.regex.Pattern.compile;

public class DateSetter extends AbstractCommand {
    private static final Pattern DATE_PATTERN = compile(
            "(?<MMDD>(0\\d|1[012])(-[01]\\d|-3[01]))|\\d{4}(?<MM>-0\\d|-1[012](?<DD>-[01]\\d|-3[01])?)?");

    private final Map<Pattern, Function<Matcher, LocalDate>> map = Map.of(
            compile("(?<date>\\d{4}-\\d{2}-\\d{2})"),
            m -> LocalDate.parse(m.group("date")),
            compile("(?<year>\\d{4})-(?<month>\\d{2})"),
            m -> date().withYear(parseInt(m.group("year"))).withMonth(parseInt(m.group("month"))),
            compile("(?<year>\\d{4})"), m -> date().withYear(parseInt(m.group("year")))
    );

    public DateSetter(Context context) {
        super(context);
    }

    @Override
    public Boolean apply(String request) {
        for (var entry : map.entrySet()) {
            final var matcher = entry.getKey().matcher(request);
            if (matcher.matches()) {
                final var date = entry.getValue().apply(matcher);
                setDate(date);
                return true;
            }
        }

        return false;
    }
}
