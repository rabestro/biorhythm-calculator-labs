package lv.id.jc.biorhythm.command;

import lv.id.jc.biorhythm.Context;
import lv.id.jc.biorhythm.ui.Component;

import java.time.LocalDate;
import java.util.Map;

public class SetDate extends Component {
    private final Map<String, LocalDate> setDate;
    private Runnable runnable;

    public SetDate(Context context) {
        super(context);
        setDate = Map.of(
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
        final var isValid = setDate.containsKey(request);
        if (isValid) {
            runnable = () -> context.setDate(setDate.get(request));
        }
        return isValid;
    }

    @Override
    public void run() {
        runnable.run();
    }

    @Override
    public String get() {
        return format("help");
    }
}
