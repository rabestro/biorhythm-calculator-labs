package lv.id.jc.biorhythm.command;

import java.util.function.Predicate;

/**
 * Command for Command Processor.
 * <p>
 * The method Boolean apply(String)
 * returns False if command is not recognized.
 * True is command is recognized and processed (even with errors message).
 */
public interface Command extends Predicate<String> {

}
