package services;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class Birthday implements Callable<LocalDate> {
    private static final Scanner scanner = new Scanner(System.in);

    @Override
    public LocalDate call() {
        System.out.println("Enter your birthday [1970-06-07]: ");
        final var data = scanner.nextLine();
        final var birthday = data.isBlank()
                ? LocalDate.of(1970, 06, 07)
                : LocalDate.parse(data);

        return birthday;
    }
}
