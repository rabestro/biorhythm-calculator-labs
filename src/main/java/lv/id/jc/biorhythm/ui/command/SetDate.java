package lv.id.jc.biorhythm.ui.command;

import lv.id.jc.biorhythm.model.Context;

import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class SetDate extends AbstractCommand {
    private static final Pattern DATE_PATTERN = compile(
            "(?<MMDD>(0\\d|1[012])(-[01]\\d|-3[01]))|\\d{4}(?<MM>-0\\d|-1[012](?<DD>-[01]\\d|-3[01])?)?");

    public SetDate(Context context) {
        super(context);
    }

    @Override
    public Boolean apply(String request) {
        final var matcher = DATE_PATTERN.matcher(request);
        if (!matcher.matches()) {
            return false;
        }
        println("This command is not implemented yet");
        return true;
    }
}
