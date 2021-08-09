package lv.id.jc.biorhythm.service;

import lv.id.jc.biorhythm.Context;
import lv.id.jc.biorhythm.service.command.Command;
import lv.id.jc.biorhythm.ui.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public class CommandProcessor extends Component {
    private static final Set<String> exit = Set.of("exit", "quit");
    private final Set<Command> commandSet = new HashSet<>();

    public CommandProcessor(Context context) {
        super(context);
    }

    public CommandProcessor addCommands(Set<Command> commands) {
        commandSet.addAll(commands);
        return this;
    }

    @Override
    public void run() {
        printf("welcome", birthday(), date());
        Stream.generate(this::getCommand)
                .takeWhile(not(exit::contains))
                .forEach(this::process);
    }

    private void process(String command) {
        commandSet.stream()
                .map(cmd -> cmd.process(command, this))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .findFirst()
                .ifPresentOrElse(Runnable::run, () -> printf("unrecognized", command));
    }

    private String getCommand() {
        printf("prompt", context.date());
        return scanner.nextLine().toLowerCase();
    }
}
