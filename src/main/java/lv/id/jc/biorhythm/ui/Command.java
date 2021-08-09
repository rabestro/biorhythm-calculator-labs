package lv.id.jc.biorhythm.ui;

import java.util.function.Predicate;
import java.util.function.Supplier;

public interface Command extends Predicate<String>, Supplier<String>, Runnable {

}
