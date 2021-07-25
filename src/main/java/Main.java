import biorhytms.Biorhythm;
import lombok.val;
import services.AgeInfo;
import services.Birthday;
import services.CLI;
import services.TestIndicators;

public class Main {
    public static void main(String[] args) {
        val params = new CLI().parseArgs(args);
        val birthday = params.getBirthday().orElseGet(new Birthday()::call);
        new AgeInfo(birthday).run();
//        new DailyReport(birthday).run();
//        new AnnualReport(birthday, LocalDate.now().getYear()).run();
//        new RequestProcessor(birthday).run();

        Biorhythm.primary().map(TestIndicators::new).forEach(TestIndicators::run);
    }
}
