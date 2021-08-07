package lv.id.jc;

import lombok.val;
import lv.id.jc.biorhythm.report.AgeInfoReport;
import lv.id.jc.biorhythm.report.Context;
import lv.id.jc.biorhythm.report.SummaryReport;
import lv.id.jc.biorhythm.service.Birthday;
import lv.id.jc.biorhythm.service.CLI;

import java.util.Random;

public class Main {
    private static final Random random = new Random();

    public static void main(String[] args) {
        val params = new CLI().parseArgs(args);
        val birthday = params.getBirthday().orElseGet(new Birthday()::call);
        val reportData = new Context(birthday);
        val randomDate = reportData
                .birthday()
                .plusDays(random.nextInt(20_000));
//        reportData.setDate(randomDate);
        new AgeInfoReport(reportData).run();
//        new DailyReport(reportData).run();
        new SummaryReport(reportData).run();

//        new RequestProcessor(birthday).run();
//        new WeeklyReport(reportData).run();
//        new AnnualReport(reportData).run();
//        Biorhythm.primary().map(TestIndicators::new).forEach(TestIndicators::run);
//        new TripleChart(reportData).run();
    }
}
