package lv.id.jc.biorhythm;

import java.time.LocalDate;

public final class Main {
    public static void main(String[] args) {
        new Application(new Context(LocalDate.EPOCH)).run();
    }
}
