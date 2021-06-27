import services.Birthday;
import services.Stage1;

public class Main {
    public static void main(String[] args) throws Exception {
        var birthday = new Birthday().call();
        new Stage1(birthday).run();
    }
}
