package tests;

import lombok.val;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.util.Random;

public class DateFormats {
    private static final Random random = new Random();

    public static void main(String[] args) {
        val randomDate = LocalDate.EPOCH.plusDays(random.nextInt(20_000));
        val fmt = new MessageFormat("{0}");
        fmt.setFormat(0, new SummaryDateFormat());
        val out = fmt.format(new Object[]{randomDate});

        System.out.println(out);
    }
}
