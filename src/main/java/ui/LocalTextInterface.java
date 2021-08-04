package ui;

import java.util.ResourceBundle;

public class LocalTextInterface implements TextInterface {
    private final ResourceBundle resourceBundle;

    public LocalTextInterface() {
        resourceBundle = ResourceBundle.getBundle("messages");
    }

    @Override
    public void print(final String key, final Object... args) {
        final var format = resourceBundle.containsKey(key) ? resourceBundle.getString(key) : key;
        TextInterface.super.print(format, args);
    }

    public void printf(final String key, final Object... args) {
        System.out.printf(resourceBundle.getString(key), args);
    }
}
