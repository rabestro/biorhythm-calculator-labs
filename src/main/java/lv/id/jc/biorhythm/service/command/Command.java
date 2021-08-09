package lv.id.jc.biorhythm.service.command;

import lv.id.jc.biorhythm.ui.Component;

import java.util.Optional;

public interface Command {
    Optional<Runnable> process(String command, Component component);
}
