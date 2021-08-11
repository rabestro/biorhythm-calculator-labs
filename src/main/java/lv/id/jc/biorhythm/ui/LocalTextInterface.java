package lv.id.jc.biorhythm.ui;

import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Pattern;

import static java.lang.System.Logger.Level.*;

public abstract class LocalTextInterface implements TextInterface {
    protected static final Scanner scanner = new Scanner(System.in);
    public static final Pattern CAMEL_CASE = Pattern.compile("(\\p{Lower})(\\p{Upper})");
    private static final ResourceBundle COMMON_BUNDLE = ResourceBundle.getBundle("messages");

    protected final ResourceBundle resourceBundle;

    protected LocalTextInterface() {
        resourceBundle = getResourceBundle();
    }

    protected LocalTextInterface(final String resourceName) {
        this.resourceBundle = ResourceBundle.getBundle(resourceName);
    }

    private ResourceBundle getResourceBundle() {
        final var className = this.getClass().getSimpleName();
        final var bundleName = CAMEL_CASE
                .matcher(this.getClass().getName().replace('.', '/'))
                .replaceAll("$1-$2")
                .toLowerCase();
        try {
            final var bundle = ResourceBundle.getBundle(bundleName);
            LOGGER.log(TRACE, "class \"{0}\" uses bundle: \"{1}\"", className, bundleName);
            return bundle;
        } catch (MissingResourceException e) {
            LOGGER.log(WARNING, "can''t find resource bundle {0}", bundleName);
            LOGGER.log(WARNING, "Error: {0}", e.getMessage());
            LOGGER.log(INFO, "class {0} uses resource bundle {1}", className, COMMON_BUNDLE);
            return COMMON_BUNDLE;
        }
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
