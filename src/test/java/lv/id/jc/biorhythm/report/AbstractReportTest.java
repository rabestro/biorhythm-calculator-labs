package lv.id.jc.biorhythm.report;

import lv.id.jc.biorhythm.model.Context;
import lv.id.jc.biorhythm.ui.Component;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.function.Function;

import static org.mockito.Mockito.when;

@Tag("date")
@DisplayName("Given Abstract Report ")
abstract class AbstractReportTest {
    static final LocalDate TOADY = LocalDate.of(2021, 8, 16);
    static final LocalDate BIRTHDAY = LocalDate.EPOCH;
    static final DateTimeFormatter FULL_DATE =
            DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).localizedBy(Locale.ENGLISH);
    final InputStream originalIn = System.in;
    final PrintStream originalOut = System.out;
    final ByteArrayOutputStream out = new ByteArrayOutputStream();

    Context context = new Context(BIRTHDAY, TOADY);
    Component underTest;

    AbstractReportTest(Function<Context, Component> component) {
        underTest = component.apply(context);
    }

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(out));

        context.setBirthday(BIRTHDAY);
        context.setDate(TOADY);
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }
}