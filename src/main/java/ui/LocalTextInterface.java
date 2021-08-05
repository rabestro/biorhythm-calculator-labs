package ui;

import java.util.ResourceBundle;

public class LocalTextInterface implements TextInterface {
    private final ResourceBundle resourceBundle;

    public LocalTextInterface() {
        resourceBundle = ResourceBundle.getBundle("messages");
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

    public String getString(final String key) {
        return resourceBundle.containsKey(key) ? resourceBundle.getString(key) : key;
    }
}
