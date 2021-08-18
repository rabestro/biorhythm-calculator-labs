package lv.id.jc.biorhythm.report;

import lv.id.jc.biorhythm.model.Context;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("Given Age Info component")
class AgeInfoTest {
    private static final LocalDate TOADY = LocalDate.of(2021, 8, 16);
    private static final LocalDate BIRTHDAY = LocalDate.EPOCH;
    private static final DateTimeFormatter FULL_DATE =
            DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).localizedBy(Locale.ENGLISH);
    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    @Mock
    private Context context;

    @InjectMocks
    private AgeInfo underTest;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(out));

        when(context.birthday()).thenReturn(BIRTHDAY);
        when(context.date()).thenReturn(TOADY);
    }

    @Test
    @DisplayName("when run() print correct information")
    void run() {
        when(context.birthday()).thenReturn(BIRTHDAY);
        when(context.date()).thenReturn(TOADY);

        underTest.run();

        final var actual = out.toString();
        final var expectedBirthday = BIRTHDAY.format(FULL_DATE);
        System.err.println(actual);

        assertTrue(actual.contains("Birthday"));
        assertTrue(actual.contains(expectedBirthday), "expected: " + expectedBirthday);
        assertTrue(actual.contains("Today"));
        assertTrue(actual.contains(TOADY.format(FULL_DATE)));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }
}