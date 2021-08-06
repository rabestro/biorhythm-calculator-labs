package lv.id.jc.services;

import java.time.LocalDate;

public class CLI {
    public Params parseArgs(String[] args) {
        final var params = new Params();
        for (int i = 0; i < args.length; i++) {
            if (args[i].equalsIgnoreCase("-birthday")) {
                params.setBirthday(LocalDate.parse(args[++i]));
            }
        }
        return params;
    }
}
