package lv.id.jc.biorhythm;

import lv.id.jc.biorhythm.model.Context;
import lv.id.jc.biorhythm.service.CLIProcessor;

public final class Main {
    public static void main(String[] args) {
        final var context = new Context();

        new CLIProcessor(context, args);
        new Application(context).run();
    }

}
