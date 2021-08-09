package lv.id.jc.biorhythm.stage;

import lv.id.jc.biorhythm.Context;
import lv.id.jc.biorhythm.report.AgeInfoReport;
import lv.id.jc.biorhythm.report.ZodiacSignReport;
import lv.id.jc.biorhythm.service.AskBirthday;
import lv.id.jc.biorhythm.service.CommandProcessor;
import lv.id.jc.biorhythm.command.MoveDate;
import lv.id.jc.biorhythm.command.Info;

import java.time.LocalDate;

public class Stage3 {
    public static void main(String[] args) {
        final var context = new Context(LocalDate.MIN);

        new AskBirthday(context).run();
        new AgeInfoReport(context).run();
        new ZodiacSignReport(context).run();

        new CommandProcessor(context)
                .add(MoveDate::new)
                .add(Info::new)
                .add(AskBirthday::new)
                .run();
    }

}
