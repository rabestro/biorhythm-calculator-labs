package lv.id.jc.service;

import lombok.val;
import lv.id.jc.report.Context;
import lv.id.jc.ui.LocalTextInterface;

public class DateNavigator extends LocalTextInterface implements Runnable {
    private final Context context;

    public DateNavigator(final Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        while (true) {
            printf("prompt", context.date());
            val command = scanner.nextLine().toLowerCase();
            if ("exit".equals(command) || "quit".equals(command)) {
                return;
            }
        }
    }
}
