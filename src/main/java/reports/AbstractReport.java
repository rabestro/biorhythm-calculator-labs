package reports;

import java.text.MessageFormat;
import java.time.LocalDate;

public abstract class AbstractReport implements Runnable {
    protected final ReportData reportData;

    public AbstractReport(final ReportData reportData) {
        this.reportData = reportData;
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
