package reports;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.Random;

import static java.time.LocalDate.EPOCH;

public abstract class AbstractReport implements Runnable {
    static final System.Logger LOGGER = System.getLogger("");
    static final Random random = new Random();
    static final int MAX_DAYS = 20_000;

    protected final ReportData reportData;

    public AbstractReport(final ReportData reportData) {
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

    public static String dayOrdinal(final int day) {
        return MessageFormat.format(
                "{0}{0,choice,1#st|2#nd|3#rd|3<th|21#st|22#nd|23#rd|23<th|31#st}", day);
    }
}
