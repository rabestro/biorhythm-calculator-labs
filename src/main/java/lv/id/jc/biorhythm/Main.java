package lv.id.jc.biorhythm;

import lv.id.jc.biorhythm.service.CLIProcessor;

import java.time.LocalDate;

public final class Main {
    public static void main(String[] args) {
        final var context = new Context();

        new CLIProcessor(context, args);
        new Application(context).run();
    }

}
