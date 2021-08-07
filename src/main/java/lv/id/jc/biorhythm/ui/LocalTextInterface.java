package lv.id.jc.biorhythm.ui;

import java.util.ResourceBundle;
import java.util.Scanner;

import static java.lang.System.Logger.Level.TRACE;

public class LocalTextInterface implements TextInterface {
    protected static final Scanner scanner = new Scanner(System.in);
    private final ResourceBundle resourceBundle;

    public LocalTextInterface() {
        final var bundleName = this.getClass().getName()
                .replace('.', '/')
                .replaceAll("(\\p{Lower})(\\p{Upper})", "$1-$2")

                .toLowerCase();
        LOGGER.log(TRACE, "class \"{0}\" uses bundle: \"{1}\"",
                this.getClass().getSimpleName(), bundleName);
        resourceBundle = ResourceBundle.getBundle(bundleName);
    }

    public LocalTextInterface(final String resourceName) {
        this.resourceBundle = ResourceBundle.getBundle(resourceName);
    }

    @Override
    public void print(final String key, final Object... args) {
        TextInterface.super.print(getString(key), args);
    }

    public void printf(final String key, final Object... args) {
        System.out.printf(getString(key), args);
    }

    public String format(final String key, final Object... args) {
        return String.format(getString(key), args);
    }

    public String getString(final String key) {
        return resourceBundle.containsKey(key) ? resourceBundle.getString(key) : key;
    }
}
