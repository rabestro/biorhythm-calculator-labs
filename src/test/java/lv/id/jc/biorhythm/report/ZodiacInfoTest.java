package lv.id.jc.biorhythm.report;

import lv.id.jc.biorhythm.model.Context;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
@DisplayName("Given Zodiac Sign Report")
class ZodiacInfoTest {
    static final LocalDate TOADY = LocalDate.of(2021, 8, 16);
    static final LocalDate BIRTHDAY = LocalDate.EPOCH;

    @InjectMocks
    private ZodiacInfo underTest;

    @BeforeEach
    void setUp() {
        final var context = new Context(BIRTHDAY, TOADY);
        underTest = new ZodiacInfo(context);
    }

    @Test
    @DisplayName("when get contains labels")
    void get() {
        final var output = underTest.get();

        assertTrue(output.contains("Zodiac Sign"));
        assertTrue(output.contains("Symbol"));
        assertTrue(output.contains("Dates"));
        assertTrue(output.contains("Lucky Day"));
    }
}