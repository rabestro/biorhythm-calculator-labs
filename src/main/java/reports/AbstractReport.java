package reports;

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
}
