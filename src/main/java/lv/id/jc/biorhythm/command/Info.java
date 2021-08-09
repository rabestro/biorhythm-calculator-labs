package lv.id.jc.biorhythm.command;

import lv.id.jc.biorhythm.Context;
import lv.id.jc.biorhythm.ui.Component;

import java.util.Set;

public class Info extends Component {
    private static final Set<String> information = Set.of("help", "info");

    public Info(Context context) {
        super(context);
    }

    @Override
    public void run() {
        printf("info");
    }

}
