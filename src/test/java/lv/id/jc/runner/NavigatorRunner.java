package lv.id.jc.runner;

import lv.id.jc.service.DateNavigator;

public class NavigatorRunner extends AbstractRunner {
    static {
        runner = DateNavigator::new;
    }
}
