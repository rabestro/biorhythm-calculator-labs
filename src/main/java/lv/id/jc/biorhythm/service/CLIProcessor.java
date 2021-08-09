package lv.id.jc.biorhythm.service;

import lv.id.jc.biorhythm.Context;
import lv.id.jc.biorhythm.ui.Component;

import java.time.LocalDate;

public class CLIProcessor extends Component {
    private final String[] args;

    public CLIProcessor(final Context context, String... args) {
        super(context);
        this.args = args;
    }

    @Override
    public void run() {
        for (int i = 0; i < args.length; i++) {
            if (args[i].equalsIgnoreCase("--birthday")) {
                context.setBirthday(LocalDate.parse(args[++i]));
            }
        }
    }
}
