package lv.id.jc.biorhythm.stage;

import lv.id.jc.biorhythm.Context;
import lv.id.jc.biorhythm.report.AgeInfo;
import lv.id.jc.biorhythm.report.DailyReport;
import lv.id.jc.biorhythm.report.ZodiacInfo;
import lv.id.jc.biorhythm.service.AskBirthday;

import java.time.LocalDate;

public class Stage2 {
    public static void main(String[] args) {
        final var context = new Context(LocalDate.MIN);

        new AskBirthday(context).run();
        new AgeInfo(context).run();
        new ZodiacInfo(context).run();
        new DailyReport(context).run();
    }
}
