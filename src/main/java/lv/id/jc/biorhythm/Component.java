package lv.id.jc.biorhythm;

import lv.id.jc.biorhythm.ui.LocalTextInterface;

import java.time.LocalDate;

public abstract class Component extends LocalTextInterface implements Runnable {
    protected final Context context;

    public Component(final Context context) {
        this.context = context;
    }

    protected LocalDate birthday() {
        return context.birthday();
    }

    protected LocalDate date() {
        return context.date();
    }

}
