package lv.id.jc.biorhythm.service;

import lv.id.jc.biorhythm.Context;
import lv.id.jc.biorhythm.service.command.Command;
import lv.id.jc.biorhythm.ui.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public class Processor extends Component {
    private static final Set<String> exit = Set.of("exit", "quit");
    private final Set<Command> commandSet = new HashSet<>();

    public Processor(Context context) {
        super(context);
    }

    public Processor addCommands(Set<Command> commands) {
        commandSet.addAll(commands);
        return this;
    }

    @Override
    public void run() {
        printf("welcome", birthday(), date());
        Stream.generate(this::askRequest)
                .takeWhile(not(exit::contains))
                .forEach(this::processRequest);
    }

    private void processRequest(String request) {
        commandSet.stream()
                .map(cmd -> cmd.process(request, this))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .ifPresentOrElse(Runnable::run, () -> printf("unrecognized", request));
    }

    private String askRequest() {
        printf("prompt", context.date());
        return scanner.nextLine().toLowerCase();
    }
}
