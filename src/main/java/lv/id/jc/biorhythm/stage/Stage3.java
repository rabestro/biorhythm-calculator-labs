package lv.id.jc.biorhythm.stage;

import lv.id.jc.biorhythm.Context;
import lv.id.jc.biorhythm.report.AgeInfoReport;
import lv.id.jc.biorhythm.report.ZodiacSignReport;
import lv.id.jc.biorhythm.service.BirthdayRequester;
import lv.id.jc.biorhythm.service.CommandProcessor;
import lv.id.jc.biorhythm.service.command.DateMove;
import lv.id.jc.biorhythm.service.command.Information;

import java.time.LocalDate;
import java.util.Set;

public class Stage3 {
    public static void main(String[] args) {
        final var context = new Context(LocalDate.MIN);

        new BirthdayRequester(context).run();
        new AgeInfoReport(context).run();
        new ZodiacSignReport(context).run();
        new CommandProcessor(context)
                .addCommands(Set.of(new Information(), new DateMove()))
                .run();
    }

}
