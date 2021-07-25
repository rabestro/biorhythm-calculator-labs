import reports.DailyReport;
import services.*;

public class Main {
    public static void main(String[] args) {
        var params = new CLI().parseArgs(args);

        var birthday = params.getBirthday().orElseGet(new Birthday()::call);
        new AgeInfo(birthday).run();
        new DailyReport(birthday).run();
//        new AnnualReport(birthday, LocalDate.now().getYear()).run();
        new RequestProcessor(birthday).run();
    }
}
