package lv.id.jc.biorhythm.ui;

import lv.id.jc.biorhythm.model.Context;

import java.time.LocalDate;

import static java.lang.System.Logger.Level.TRACE;
import static java.time.LocalDate.EPOCH;

public abstract class Component extends LocalTextInterface implements Runnable {
    protected final Context context;
    protected Runnable runnable = () -> printf("component %s is running", this.getClass().getSimpleName());
    protected String command = CAMEL_CASE.matcher(this.getClass().getSimpleName())
            .replaceAll("$1 $2")
            .toLowerCase();

    protected Component() {
        this(new Context(EPOCH, EPOCH));
    }

    protected Component(final Context context) {
        this.context = context;
        LOGGER.log(TRACE, "class {0} initialized with {1}", this.getClass().getSimpleName(), context);
    }

    public Context getContext() {
        return context;
    }

    protected LocalDate birthday() {
        return context.birthday();
    }

    public LocalDate date() {
        return context.date();
    }

    public void setDate(LocalDate date) {
        context.setDate(date);
    }

    @Override
    public void run() {
        runnable.run();
    }

    protected String getCommand() {
        return CAMEL_CASE
                .matcher(this.getClass().getSimpleName())
                .replaceAll("$1 $2")
                .toLowerCase();
    }
}
