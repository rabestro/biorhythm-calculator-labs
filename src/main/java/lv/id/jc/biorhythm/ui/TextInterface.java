package lv.id.jc.biorhythm.ui;

import java.text.MessageFormat;
import java.util.Scanner;

public interface TextInterface {
    System.Logger LOGGER = System.getLogger("");
    Scanner scanner = new Scanner(System.in);

    default void println() {
        System.out.println();
    }

    default void print(final String format, final Object... args) {
        System.out.print(MessageFormat.format(format, args));
    }

    default void println(final String format, final Object... args) {
        print(format, args);
        println();
    }

}
