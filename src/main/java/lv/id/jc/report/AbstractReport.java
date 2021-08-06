package lv.id.jc.report;

import lv.id.jc.ui.LocalTextInterface;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public abstract class AbstractReport extends LocalTextInterface implements Runnable {
    static final DateTimeFormatter LONG_DATE = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);

    protected final Context context;

    public AbstractReport(final Context context) {
        this.context = context;
    }

    public AbstractReport(final String resourceName, final Context context) {
        super(resourceName);
        this.context = context;
    }

    protected LocalDate birthday() {
        return context.getBirthday();
    }

    protected LocalDate date() {
        return context.getDate();
    }

}
