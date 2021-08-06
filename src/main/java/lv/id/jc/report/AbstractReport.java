package lv.id.jc.report;

import lv.id.jc.ui.LocalTextInterface;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Random;

import static java.time.LocalDate.EPOCH;

public abstract class AbstractReport extends LocalTextInterface implements Runnable {
    static final DateTimeFormatter LONG_DATE = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);

    static final Random random = new Random();
    static final int MAX_DAYS = 20_000;

    protected final ReportData reportData;

    public AbstractReport(final ReportData reportData) {
        this.reportData = reportData;
    }

    public AbstractReport(final String resourceName, final ReportData reportData) {
        super(resourceName);
        this.reportData = reportData;
    }

    public AbstractReport() {
        reportData = new ReportData(EPOCH, EPOCH.plusDays(random.nextInt(MAX_DAYS)));
    }

    protected LocalDate birthday() {
        return reportData.getBirthday();
    }

    protected LocalDate date() {
        return reportData.getDate();
    }

}
