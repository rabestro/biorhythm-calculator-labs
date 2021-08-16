package lv.id.jc.biorhythm.ui.command;

import lv.id.jc.biorhythm.model.Context;
import lv.id.jc.biorhythm.ui.Component;

public abstract class AbstractCommand extends Component implements Command {
    public AbstractCommand(Context context) {
        super(context);
    }

    public String help() {
        if (resourceBundle.containsKey("help")) {
            return resourceBundle.getString("help");
        }

        final var className = this.getClass().getSimpleName();
        return String.format("%-15s - run component \"%s\"%n", getCommand(), className);
    }

    private String getCommand() {
        return CAMEL_CASE
                .matcher(this.getClass().getSimpleName())
                .replaceAll("$1 $2")
                .toLowerCase();
    }

    @Override
    public Boolean apply(String request) {
        if (getCommand().equalsIgnoreCase(request)) {
            this.run();
            return true;
        }
        return false;
    }
}
