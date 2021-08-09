package lv.id.jc.biorhythm.stage;

import lv.id.jc.biorhythm.Context;
import lv.id.jc.biorhythm.report.AgeInfoReport;
import lv.id.jc.biorhythm.report.DailyReport;
import lv.id.jc.biorhythm.report.ZodiacSignReport;
import lv.id.jc.biorhythm.service.BirthdayRequester;

import java.time.LocalDate;

public class Stage2 {
    public static void main(String[] args) {
        final var context = new Context(LocalDate.MIN);

        new BirthdayRequester(context).run();
        new AgeInfoReport(context).run();
        new ZodiacSignReport(context).run();
        new DailyReport(context).run();
    }
}
