package lv.id.jc.biorhythm.report;

import lv.id.jc.biorhythm.ui.Component;
import lv.id.jc.biorhythm.Context;
import lv.id.jc.biorhythm.format.BiorhythmFormat;
import lv.id.jc.biorhythm.format.DaysFormat;
import lv.id.jc.biorhythm.format.MultilineTextFormat;
import lv.id.jc.biorhythm.format.OrdinalDateFormat;
import lv.id.jc.biorhythm.model.Biorhythm;

import java.text.Format;
import java.util.stream.Stream;

public class SummaryReport extends Component {
    private static final Format ORDINAL_DATE_FORMAT = new OrdinalDateFormat();
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
        printf("summary.biorhythm.name.format", value.getBiorhythm());
        print(multilineFormat.format(format(getString(value.getStage().name()),
                value.getBiorhythm().name().toLowerCase(),
                value.getBiorhythm().getAttributes(),
                ORDINAL_DATE_FORMAT.format(value.changeDate()),
                DAYS_FORMAT.format(value.changeInDays()))));
    }
}
