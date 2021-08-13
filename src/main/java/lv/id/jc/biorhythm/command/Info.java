package lv.id.jc.biorhythm.command;

import lv.id.jc.biorhythm.model.Context;
import lv.id.jc.biorhythm.ui.Component;

public class Info extends Component {

    public Info(Context context) {
        super(context);
        runnable = () -> printf("info");
    }

}
