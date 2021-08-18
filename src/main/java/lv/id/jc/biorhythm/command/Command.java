package lv.id.jc.biorhythm.command;

import java.util.function.Function;

/**
 * Command for Command Processor.
 * <p>
 * The method Boolean apply(String)
 * returns False if command is not recognized.
 * True is command is recognized and processed (even with errors message).
 */
public interface Command extends Function<String, Boolean> {

    default String help() {
        final var commandName = this.getClass().getSimpleName().toLowerCase();
        return commandName + " - help is not implemented yet.";
    }
}
