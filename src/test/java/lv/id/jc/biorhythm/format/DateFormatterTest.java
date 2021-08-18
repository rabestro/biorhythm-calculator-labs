package lv.id.jc.biorhythm.format;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("Formatter")
@DisplayName("Given DateFormatter")
class DateFormatterTest {

    private DateTimeFormatter underTest;

    @Nested
    @DisplayName("Given ROMAN_FULL")
    class FullRomanDate {
        @BeforeEach
        void setUp() {
            underTest = DateFormatter.ROMAN_FULL;
        }

        @ParameterizedTest(name = "when format {0} then {1}")
        @CsvFileSource(resources = "/format/roman-date-format.csv", numLinesToSkip = 1)
        void formatFullRoman(final LocalDate date, final String expected) {
            assertEquals(expected, underTest.format(date));
        }

        @ParameterizedTest(name = "when parse {1} then {0}")
        @CsvFileSource(resources = "/format/roman-date-format.csv", numLinesToSkip = 1)
        void parseFullRoman(final LocalDate expected, final String roman) {
            final var actual = underTest.parse(roman, LocalDate::from);
            assertEquals(expected, actual);
        }
    }
    @Nested
    @DisplayName("Given ROMAN_SHORT")
    class RomanShortDate {
        @BeforeEach
        void setUp() {
            underTest = DateFormatter.ROMAN_SHORT;
        }

        @ParameterizedTest(name = "when format {0} then {1}")
        @CsvFileSource(resources = "/format/roman-short.csv", numLinesToSkip = 1)
        void formatFullRoman(final MonthDay date, final String expected) {
            assertEquals(expected, underTest.format(date));
        }

        @ParameterizedTest(name = "when parse {1} then {0}")
        @CsvFileSource(resources = "/format/roman-short.csv", numLinesToSkip = 1)
        void parseFullRoman(final MonthDay expected, final String roman) {
            final var actual = underTest.parse(roman, MonthDay::from);
            assertEquals(expected, actual);
        }
    }
}