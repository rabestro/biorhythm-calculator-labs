package lv.id.jc.biorhythm.ui;

import java.util.function.Predicate;
import java.util.function.Supplier;

import static lv.id.jc.biorhythm.ui.LocalTextInterface.CAMEL_CASE;

public interface Command extends Predicate<String>, Supplier<String>, Runnable {

    default boolean test(String request) {
        return getCommand().equalsIgnoreCase(request);
    }

    default String get() {
        final var className = this.getClass().getSimpleName();
        return String.format("%-15s - run component \"%s\"%n", getCommand(), className);
    }

    private String getCommand() {
        return CAMEL_CASE
                .matcher(this.getClass().getSimpleName())
                .replaceAll("$1 $2")
                .toLowerCase();
    }
}
