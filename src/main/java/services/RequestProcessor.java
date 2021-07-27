package services;

import lombok.val;
import reports.DailyReport;
import reports.ReportData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class RequestProcessor implements Runnable {
    private static final DateTimeFormatter LONG_DATE = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
    private static final Scanner scanner = new Scanner(System.in);
    private final DailyReport dailyReport;
    private final ReportData reportData;
    private LocalDate day;

    public RequestProcessor(final LocalDate birthday) {
        reportData = new ReportData(birthday);
        dailyReport = new DailyReport(reportData);
    }

    @Override
    public void run() {
        while (true) {
            System.out.println();
            System.out.println(day.format(LONG_DATE));
            System.out.print("Enter a request: ");

            val request = new LinkedList<String>(Arrays.asList(scanner.nextLine().toUpperCase().split(" ")));
            var cmd = request.poll();
            if ("exit".equalsIgnoreCase(cmd)) {
                return;
            }
            if ("print".equalsIgnoreCase(cmd)) {
                reportData.setDate(day);
                dailyReport.run();
                continue;
            }
            if ("today".equalsIgnoreCase(cmd)) {
                day = LocalDate.now();
                continue;
            }
            int shift = 0;
            if ("NEXT".equals(cmd)) {
                shift = +1;
            } else if ("PREV".equals(cmd)) {
                shift = -1;
            } else {
                shift = Integer.parseInt(cmd);
            }
            cmd = request.poll();
            switch (cmd) {
                case "DECADE":
                    reportData.setDate(day.plus(shift, ChronoUnit.DECADES));
                    continue;
                case "YEAR":
                    reportData.setDate(day.plus(shift, ChronoUnit.YEARS));
                    continue;
                case "MONTH":
                    reportData.setDate(day.plus(shift, ChronoUnit.MONTHS));
                    continue;
                case "WEEK":
                    reportData.setDate(day.plus(shift, ChronoUnit.WEEKS));
                    continue;
                case "DAY":
                    reportData.setDate(day.plus(shift, ChronoUnit.DAYS));
                    continue;
            }
        }
    }
}
