package lv.id.jc.biorhythm.command;

import lv.id.jc.biorhythm.model.Context;

import java.time.LocalDate;
import java.util.regex.Pattern;

import static lv.id.jc.biorhythm.format.DateFormatter.ROMAN_FULL_DATE;

public class RomanDateSetter extends DateCommand {
    private static final Pattern ROMAN_DATE_PATTERN = Pattern.compile("" +
            "\\d?\\d" +    // Day
            "/" +
            "[IVX]{1,4}" + // Month (Roman numerals)
            "/" +
            "\\d{4}",        // Year
            Pattern.CASE_INSENSITIVE
    );

    public RomanDateSetter(Context context) {
        super(context);
    }

    @Override
    public boolean test(String request) {
        if (!ROMAN_DATE_PATTERN.matcher(request).matches()) {
            return false;
        }
        final var date = ROMAN_FULL_DATE.parse(request.toUpperCase()).query(LocalDate::from);
        context.setDate(date);
        return true;
    }
}
