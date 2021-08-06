package lv.id.jc.runner;

import lv.id.jc.service.DateNavigator;

public class NavigatorRunner extends AbstractRunner {
    static {
        reportRunner = DateNavigator::new;
    }
}
