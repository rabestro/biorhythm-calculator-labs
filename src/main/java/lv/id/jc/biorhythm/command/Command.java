package lv.id.jc.biorhythm.command;

import java.util.function.Predicate;

/**
 * Command for Command Processor.
 * <p>
 * The method boolean test(String)
 *
 * @param request  - request (String) from the user
 * @return false if command is not recognized.
 * true is command is recognized and processed (even with errors messages).
 */
public interface Command extends Predicate<String> {

}
