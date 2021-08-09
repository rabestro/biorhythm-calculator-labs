package lv.id.jc.biorhythm.report;

import lv.id.jc.biorhythm.Context;
import lv.id.jc.biorhythm.model.ZodiacSign;
import lv.id.jc.biorhythm.ui.Component;

public class ZodiacSignReport extends Component {
    public ZodiacSignReport(Context context) {
        super(context);
    }

    @Override
    public void run() {
        final var zodiacSign = ZodiacSign.of(birthday());

    }
}
