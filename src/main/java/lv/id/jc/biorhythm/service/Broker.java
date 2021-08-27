package lv.id.jc.biorhythm.service;

import lv.id.jc.biorhythm.command.Command;
import lv.id.jc.biorhythm.model.Context;
import lv.id.jc.biorhythm.model.IllegalContextDate;
import lv.id.jc.biorhythm.ui.Component;

import java.util.LinkedHashSet;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Stream;

import static java.lang.System.Logger.Level.TRACE;
import static java.util.function.Predicate.not;

public class Broker extends Component {
    private static final String HELP = "help";
    private static final ResourceBundle helpBundle = ResourceBundle.getBundle(HELP);
    private static final Set<String> exit = Set.of("exit", "quit");
    private final Set<Command> commandSet = new LinkedHashSet<>();
    private final Command helpCommand = new Help();

    public Broker(Context context) {
        super(context);
        commandSet.add(helpCommand);
    }

    public Broker add(Function<Context, Command> component) {
        commandSet.add(component.apply(context));
        return this;
    }

    @Override
    public void run() {
        printf("welcome", birthday(), date());

        Stream.generate(this::askRequest)
                .takeWhile(not(exit::contains))
                .forEach(this::processRequest);
    }

    private String askRequest() {
        printf("prompt", context.getDate());
        return scanner.nextLine().toLowerCase();
    }

    private void processRequest(String request) {
        LOGGER.log(TRACE, "request: \"{0}\"", request);
        try {
            commandSet.stream()
                    .filter(command -> command.test(request))
                    .findFirst()
                    .ifPresentOrElse(
                            executed -> LOGGER.log(TRACE, "command `{0}` executed", request),
                            () -> printf("unrecognized", request));
        } catch (IllegalContextDate ex) {
            println(ex.getMessage());
        }
    }

    class Help implements Command {
        @Override
        public boolean test(String request) {
            if (!HELP.equalsIgnoreCase(request)) {
                return false;
            }
            commandSet.stream()
                    .map(Command::getClass)
                    .map(Class::getSimpleName)
                    .map("help."::concat)
                    .filter(helpBundle::containsKey)
                    .map(helpBundle::getString)
                    .forEach(Broker.this::printf);
            return true;
        }
    }
}
