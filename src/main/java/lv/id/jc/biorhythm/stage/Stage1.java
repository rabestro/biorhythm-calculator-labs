package lv.id.jc.biorhythm.stage;

import lv.id.jc.biorhythm.Context;
import lv.id.jc.biorhythm.report.AgeInfoReport;
import lv.id.jc.biorhythm.report.ZodiacSignReport;
import lv.id.jc.biorhythm.service.AskBirthday;

import java.time.LocalDate;

public class Stage1 {
    public static void main(String[] args) {
        final var context = new Context(LocalDate.MIN);

        new AskBirthday(context).run();
        new AgeInfoReport(context).run();
        new ZodiacSignReport(context).run();
    }
}