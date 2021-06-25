import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class Stage1 implements Runnable {
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        System.out.println("Enter your birthday: ");
        final var birthday = LocalDate.parse(scanner.nextLine());
        final var today = LocalDate.now();
        final var days = Period.between(birthday, today).getDays();
        System.out.println("Your birthday is " + birthday);
        System.out.println("Today is " + today);
        System.out.println("Days spend from your birthday " + days);
    }
}
