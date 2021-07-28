package reports;

import biorhytms.Biorhythm;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AnnualReport extends AbstractReport {

    public AnnualReport(final ReportData reportData) {
        super(reportData);
    }

    @Override
    public void run() {
        System.out.println();
        System.out.println("      Birthday: " + reportData.getBirthday()
                + "           Annual report for "
                + reportData.getYear() + " year");
        System.out.println();
        Function<Month, String> shortName = month ->
                String.format("%-6s", month.getDisplayName(TextStyle.SHORT, Locale.getDefault()));

        final var headerMonths = "      " + Arrays
                .stream(Month.values())
                .map(shortName)
                .collect(Collectors.joining());

        final var headerPEI = "   " + "   PEI".repeat(Month.values().length);
        System.out.println(headerMonths);
        System.out.println(headerPEI);

        for (int day = 1; day < 32; day++) {
            System.out.printf("%3d   ", day);
            for (int month = 1; month < 13; month++) {
                System.out.printf("%1s%1s%1s   ", getIndicators(month, day));
            }
            System.out.println();
        }
    }

    private Object[] getIndicators(final int month, final int day) {
        try {
            final var date = LocalDate.of(reportData.getYear(), month, day);
            final var days = ChronoUnit.DAYS.between(reportData.getBirthday(), date);
            return Biorhythm.primary()
                    .map(biorhythm -> biorhythm.new Value(days))
                    .map(Indicator::new)
                    .toArray(Indicator[]::new);

        } catch (DateTimeException e) {
            return new Indicator[]{Indicator.EMPTY, Indicator.EMPTY, Indicator.EMPTY};
        }
    }

}
