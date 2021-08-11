package lv.id.jc.biorhythm.ui;

import lv.id.jc.biorhythm.Context;

import java.time.LocalDate;
import java.util.function.Predicate;
import java.util.function.Supplier;

import static java.lang.System.Logger.Level.TRACE;
import static java.time.LocalDate.EPOCH;

public abstract class Component extends LocalTextInterface implements Predicate<String>, Supplier<String>, Runnable {
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
    public boolean test(String request) {
        return getCommand().equalsIgnoreCase(request);
    }

    @Override
    public String get() {
        final var className = this.getClass().getSimpleName();
        return String.format("%-15s - run component \"%s\"%n", getCommand(), className);
    }

    @Override
    public void run() {
        runnable.run();
    }

    private String getCommand() {
        return CAMEL_CASE
                .matcher(this.getClass().getSimpleName())
                .replaceAll("$1 $2")
                .toLowerCase();
    }
}
