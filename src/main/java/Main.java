import services.Birthday;
import services.CLI;
import services.Stage1;
import services.Today;

public class Main {
    public static void main(String[] args) throws Exception {
        var params = new CLI().parseArgs(args);

        var birthday = params.getBirthday().orElseGet(new Birthday()::call);
        new Stage1(birthday).run();
        new Today(birthday).run();
//        new AnnualReport(birthday, LocalDate.now().getYear()).run();
    }
}
