package lv.id.jc.biorhythm.command;

import lv.id.jc.biorhythm.model.Context;
import lv.id.jc.biorhythm.ui.Component;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class SetDate extends Component {
    private static final Pattern DATE_PATTERN = compile(
            "(?<MMDD>(0\\d|1[012])(-[01]\\d|-3[01]))|\\d{4}(?<MM>-0\\d|-1[012](?<DD>-[01]\\d|-3[01])?)?");

    private final Map<String, LocalDate> commandsMap;

    public SetDate(Context context) {
        super(context);
        commandsMap = Map.of(
                "today", LocalDate.now(),
                "now", LocalDate.now(),
                "epoch", LocalDate.EPOCH,
                "birthday", birthday(),
                "tomorrow", LocalDate.now().plusDays(1L),
                "after tomorrow", LocalDate.now().plusDays(2L),
                "yesterday", LocalDate.now().minusDays(1L),
                "before yesterday", LocalDate.now().minusDays(2L));
    }

    @Override
    public boolean test(String request) {
        if (DATE_PATTERN.matcher(request).matches()) {
            runnable = () -> println("This command is not implemented yet");
            return true;
        }

        runnable = Optional.ofNullable(commandsMap.get(request))
                .map(date -> (Runnable) () -> context.setDate(date))
                .orElse(unrecognizedCommand);

        return !runnable.equals(unrecognizedCommand);
    }

}

