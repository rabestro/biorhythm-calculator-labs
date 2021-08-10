package lv.id.jc.biorhythm.format;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.text.Format;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Given MonthOrdinalDay")
class MonthOrdinalDayTest {
    private Format underTest;

    @BeforeEach
    void setUp() {
        underTest = new MonthOrdinalDay();
    }


    @Test
    void format() {
    }

    @Test
    @DisplayName("throws UnsupportedOperationException on parseObject call")
    void parseObject() {
        assertThrows(UnsupportedOperationException.class, () -> underTest.parseObject("1st"));
    }

}