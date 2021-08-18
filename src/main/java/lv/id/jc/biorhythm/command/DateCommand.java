package lv.id.jc.biorhythm.command;

import lv.id.jc.biorhythm.model.Context;

abstract class DateCommand implements Command {
    System.Logger LOGGER = System.getLogger("Date Command");
    final Context context;

    DateCommand(Context context) {
        this.context = context;
    }

    @Override
    public Boolean apply(String s) {
        return false;
    }
}
