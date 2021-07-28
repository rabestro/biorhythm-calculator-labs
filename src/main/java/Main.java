import lombok.val;
import reports.ReportData;
import reports.SummaryReport;
import services.AgeInfo;
import services.Birthday;
import services.CLI;

import java.util.Random;

public class Main {
    private static final Random random = new Random();

    public static void main(String[] args) {
        val params = new CLI().parseArgs(args);
        val birthday = params.getBirthday().orElseGet(new Birthday()::call);
        val reportData = new ReportData(birthday);
        val randomDate = reportData
                .getBirthday()
                .plusDays(random.nextInt(20_000));
        reportData.setDate(randomDate);

        new AgeInfo(reportData).run();
//        new DailyReport(reportData).run();
        new SummaryReport(reportData).run();

//        new RequestProcessor(birthday).run();
//        new WeeklyReport(reportData).run();
//        new AnnualReport(reportData).run();
//        Biorhythm.primary().map(TestIndicators::new).forEach(TestIndicators::run);
//        new TripleChart(reportData).run();
    }
}
