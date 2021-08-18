package lv.id.jc.biorhythm.service;

import lv.id.jc.biorhythm.model.Context;
import lv.id.jc.biorhythm.ui.Component;
import lv.id.jc.biorhythm.command.AbstractCommand;
import lv.id.jc.biorhythm.command.Command;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.lang.System.Logger.Level.TRACE;
import static java.util.function.Predicate.not;

public class Broker extends Component {
    private static final Set<String> exit = Set.of("exit", "quit");
    private final Set<Command> commandSet = new LinkedHashSet<>();
    private final Command help = new Help(context);

    public Broker(Context context) {
        super(context);
        commandSet.add(help);
    }

    public Broker add(Function<Context, Command> component) {
        commandSet.add(component.apply(context));
        return this;
    }

    @Override
    public void run() {
        printf("welcome", birthday(), date());
//        help.apply("help");

        Stream.generate(this::askRequest)
                .takeWhile(not(exit::contains))
                .forEach(this::processRequest);
    }

    private String askRequest() {
        printf("prompt", context.date());
        return scanner.nextLine().toLowerCase();
    }

    private void processRequest(String request) {
        LOGGER.log(TRACE, "request: \"{0}\"", request);
        commandSet.stream()
                .peek(cmd -> LOGGER.log(TRACE, "checking `{0}`", cmd.getClass().getSimpleName()))
                .filter(command -> command.apply(request))
                .findFirst()
                .ifPresentOrElse(
                        $ -> LOGGER.log(TRACE, "command `{0}` executed", request),
                        () -> printf("unrecognized", request));
    }

    @Override
    public boolean test(String command) {
        return false;
    }

    class Help extends AbstractCommand {
        public Help(Context context) {
            super(context);
        }

        @Override
        public Boolean apply(String s) {
            if (!"help".equalsIgnoreCase(s)) {
                return false;
            }
            commandSet.stream().map(Command::help).forEach(this::printf);
            return true;
        }
    }
}
