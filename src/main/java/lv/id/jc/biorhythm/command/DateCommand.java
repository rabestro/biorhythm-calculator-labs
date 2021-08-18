package lv.id.jc.biorhythm.command;

import lv.id.jc.biorhythm.model.Context;

abstract class DateCommand implements Command {
    final Context context;
    System.Logger LOGGER = System.getLogger("Date Command");

    DateCommand(Context context) {
        this.context = context;
    }

    @Override
    public Boolean apply(String s) {
        return false;
    }
}
