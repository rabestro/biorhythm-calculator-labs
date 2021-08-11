package lv.id.jc.biorhythm.command;

import lv.id.jc.biorhythm.Context;
import lv.id.jc.biorhythm.ui.Component;

import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

public class SetDate extends Component {

    private final Map<String, LocalDate> commandsMap;

    public SetDate(Context context) {
        super(context);
        commandsMap = Map.of(
                "today", LocalDate.now(),
                "now", LocalDate.now(),
                "epoch", LocalDate.EPOCH,
                "birthday", context.birthday(),
                "tomorrow", LocalDate.now().plusDays(1L),
                "after tomorrow", LocalDate.now().plusDays(2L),
                "yesterday", LocalDate.now().minusDays(1L),
                "before yesterday", LocalDate.now().minusDays(2L));
    }

    @Override
    public boolean test(String request) {
        runnable = Optional.ofNullable(commandsMap.get(request))
                .map(date -> (Runnable) () -> context.setDate(date))
                .orElse(unrecognizedCommand);

        return !runnable.equals(unrecognizedCommand);
    }

    @Override
    public String get() {
        return format("help");
    }
}
