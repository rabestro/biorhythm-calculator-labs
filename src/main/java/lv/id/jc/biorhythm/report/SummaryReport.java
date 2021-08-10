package lv.id.jc.biorhythm.report;

import lv.id.jc.biorhythm.Context;
import lv.id.jc.biorhythm.format.*;
import lv.id.jc.biorhythm.model.Biorhythm;
import lv.id.jc.biorhythm.ui.Component;

import java.text.Format;
import java.util.stream.Stream;

public class SummaryReport extends Component {
    private static final Format DAYS_FORMAT = new DaysFormat();
    private final Format shortInfoFormat = new BiorhythmFormat(getString("short.biorhythm.format"));
    private final Format multilineFormat = new MultilineTextFormat();

    public SummaryReport(final Context context) {
        super(context);
    }

    @Override
    public void run() {
        printf("summary.header.format");
        biorhythms().map(shortInfoFormat::format).forEach(this::println);
        biorhythms().forEach(this::printInfo);
    }

    private Stream<Biorhythm.Value> biorhythms() {
        return Biorhythm.primary().map(biorhythm -> biorhythm.new Value(context));
    }

    private void printInfo(Biorhythm.Value value) {
        final var formatter = new MonthOrdinalDay();
        printf("summary.biorhythm.name.format", value.getBiorhythm());
        print(multilineFormat.format(format(getString(value.getStage().name()),
                value.getBiorhythm().name().toLowerCase(),
                value.getBiorhythm().getAttributes(),
                formatter.format(value.changeDate()),
                DAYS_FORMAT.format(value.changeInDays()))));
    }
}
