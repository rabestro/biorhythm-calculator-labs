import services.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        var params = new CLI().parseArgs(args);

        var birthday = params.getBirthday().orElseGet(new Birthday()::call);
        new Stage1(birthday).run();
//        new Today(birthday).run();
//        new AnnualReport(birthday, LocalDate.now().getYear()).run();
    }
}
