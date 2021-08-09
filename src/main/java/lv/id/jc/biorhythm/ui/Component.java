package lv.id.jc.biorhythm.ui;

import lv.id.jc.biorhythm.Context;

import java.time.LocalDate;

import static java.lang.System.Logger.Level.TRACE;
import static java.time.LocalDate.EPOCH;

public abstract class Component extends LocalTextInterface implements Command {
    protected final Context context;

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

    /**
     * Evaluates this predicate on the given argument.
     *
     * @param command the input argument
     * @return {@code true} if the input argument matches the predicate,
     * otherwise {@code false}
     */
    @Override
    public boolean test(String command) {
        return CAMEL_CASE
                .matcher(this.getClass().getSimpleName())
                .replaceAll("$1 $2")
                .equalsIgnoreCase(command);
    }

    @Override
    public String get() {
        return getString("help");
    }
}
