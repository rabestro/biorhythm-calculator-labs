package lv.id.jc.biorhythm.service.command;

import lv.id.jc.biorhythm.ui.Component;

import java.util.Optional;
import java.util.Set;

public class Information implements Command {
    private static final Set<String> information = Set.of("help", "info");

    @Override
    public Optional<Runnable> process(String command, Component component) {
        return information.contains(command)
                ? Optional.of(() -> component.printf(command))
                : Optional.empty();
    }
}
