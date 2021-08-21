package lv.id.jc.biorhythm.command;

import lv.id.jc.biorhythm.model.Context;
import lv.id.jc.biorhythm.ui.Component;

public abstract class AbstractCommand extends Component implements Command {
    protected AbstractCommand(Context context) {
        super(context);
    }

    @Override
    public boolean test(String request) {
        if (getCommand().equalsIgnoreCase(request)) {
            this.run();
            return true;
        }
        return false;
    }

}
