package lv.id.jc.biorhythm.service;

import lv.id.jc.biorhythm.model.Context;
import lv.id.jc.biorhythm.ui.Component;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public class CommandProcessor extends Component {
    private static final Set<String> exit = Set.of("exit", "quit");
    private final Set<Component> commandSet = new LinkedHashSet<>();
    private final Component help = new Help();

    public CommandProcessor(Context context) {
        super(context);
        commandSet.add(help);
    }

    public CommandProcessor add(Function<Context, Component> component) {
        commandSet.add(component.apply(context));
        return this;
    }

    @Override
    public void run() {
        printf("welcome", birthday(), date());
        help.run();

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
        {
            runnable = () -> commandSet.stream().map(Supplier::get).forEach(this::printf);
        }
    }
}
