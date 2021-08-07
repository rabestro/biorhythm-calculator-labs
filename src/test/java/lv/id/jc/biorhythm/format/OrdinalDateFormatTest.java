package lv.id.jc.biorhythm.format;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.Format;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@Tag("Formatter")
@ExtendWith(MockitoExtension.class)
@DisplayName("Test OrdinalDateFormat class")
public class OrdinalDateFormatTest {
    private static final String ORDINAL_DATE = "<#>";

    @Mock
    private Format ordinalDayFormat;

    @InjectMocks
    private OrdinalDateFormat underTest;

    @BeforeEach
    void setUp() {
    }

    @Test
    @DisplayName("checks format for month and day of the week")
    void testFormat() {
        when(ordinalDayFormat.format(any(), any(), any()))
                .thenReturn(new StringBuffer(ORDINAL_DATE));

        final var actual = underTest.format(LocalDate.EPOCH);
        final var expected = "Thursday, January " + ORDINAL_DATE;

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("throws UnsupportedOperationException on parseObject call")
    void parseObject() {
        assertThrows(UnsupportedOperationException.class, () -> underTest.parseObject("Thursday, January 1st"));
    }
}