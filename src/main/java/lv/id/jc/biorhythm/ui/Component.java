package lv.id.jc.biorhythm.ui;

import lv.id.jc.biorhythm.Context;

import java.time.LocalDate;

import static java.lang.System.Logger.Level.TRACE;
import static java.time.LocalDate.EPOCH;

public abstract class Component extends LocalTextInterface implements Runnable {
    protected final Context context;

    protected Component() {
        this(new Context(EPOCH, EPOCH));
    }

    protected Component(final Context context) {
        this.context = context;
        LOGGER.log(TRACE, "class {0} initialized with {1}", this.getClass().getSimpleName(), context);
    }

    protected LocalDate birthday() {
        return context.birthday();
    }

    protected LocalDate date() {
        return context.date();
    }

}
