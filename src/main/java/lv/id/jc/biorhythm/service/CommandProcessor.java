package lv.id.jc.biorhythm.service;

import lv.id.jc.biorhythm.Context;
import lv.id.jc.biorhythm.ui.Command;
import lv.id.jc.biorhythm.ui.Component;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.lang.System.Logger.Level.TRACE;
import static java.util.function.Predicate.not;

public class CommandProcessor extends Component {
    private static final Set<String> exit = Set.of("exit", "quit");
    private final Set<Command> commandSet = new LinkedHashSet<>();

    public CommandProcessor(Context context) {
        super(context);
        commandSet.add(new Help());
    }

    public CommandProcessor add(Function<Context, Command> component) {
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
        printf("prompt", context.date());
        return scanner.nextLine().toLowerCase();
    }

    private void processRequest(String request) {
        commandSet.stream()
                .filter(command -> command.test(request))
                .findFirst()
                .ifPresentOrElse(Runnable::run, () -> printf("unrecognized", request));
    }

    @Override
    public boolean test(String command) {
        return false;
    }

    class Help extends Component {
        @Override
        public void run() {
            LOGGER.log(TRACE, "Total commands {0}", commandSet.size());
            commandSet.stream().map(Supplier::get).forEach(CommandProcessor.this::printf);
        }
    }
}
