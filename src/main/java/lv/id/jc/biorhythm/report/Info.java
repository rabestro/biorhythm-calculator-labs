package lv.id.jc.biorhythm.report;

import lv.id.jc.biorhythm.command.AbstractCommand;
import lv.id.jc.biorhythm.model.Context;

import java.util.Objects;
import java.util.regex.Pattern;

public class Info extends AbstractCommand {
    private static final Pattern pattern = Pattern
            .compile("info(?: +(?<topic>\\w+))?", Pattern.CASE_INSENSITIVE);

    public Info(Context context) {
        super(context);
    }

    @Override
    public boolean test(String request) {
        final var matcher = pattern.matcher(request);
        if (!matcher.matches()) {
            return false;
        }
        final var topic = matcher.group("topic");
        final var key = "info." + Objects.toString(topic, "about");
        if (resourceBundle.containsKey(key)) {
            printf(getString(key));
        } else {
            printf("info.none", topic);
        }
        return true;
    }
}
