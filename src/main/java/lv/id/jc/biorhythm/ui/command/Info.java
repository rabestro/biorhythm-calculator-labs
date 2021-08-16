package lv.id.jc.biorhythm.ui.command;

import lv.id.jc.biorhythm.model.Context;

import java.util.Objects;
import java.util.regex.Pattern;

public class Info extends AbstractCommand {
    private static final Pattern pattern = Pattern.compile("info(?: +(?<topic>\\w+))?");

    public Info(Context context) {
        super(context);
    }

    @Override
    public Boolean apply(String request) {
        final var matcher = pattern.matcher(request);
        if (!matcher.matches()) {
            return false;
        }
        printf("info." + Objects.toString(matcher.group("topic"), "about"));
        return true;
    }
}
