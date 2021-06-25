import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Stage1 implements Runnable {
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public void run() {
        System.out.println("Enter your birthday [1970-06-07]: ");
        final var data = scanner.nextLine();
        final var birthday = data.isBlank()
                ? LocalDate.of(1970, 06, 07)
                : LocalDate.parse(data);

        final var today = LocalDate.now();
        final var days = ChronoUnit.DAYS.between(birthday, today);
        final var period = Period.between(birthday, today);

        System.out.println("Your birthday is " + birthday);
        System.out.println("Today is " + today);
        System.out.println("Days spend from your birthday " + days);

        System.out.println(MessageFormat.format(
                "You live {0} years, {1} months and {2} days",
                period.getYears(), period.getMonths(), period.getDays()));
    }
}
