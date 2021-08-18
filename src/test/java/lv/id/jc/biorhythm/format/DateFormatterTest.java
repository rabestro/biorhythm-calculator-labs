package lv.id.jc.biorhythm.format;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Tag("Formatter")
@DisplayName("Given DateFormatter")
class DateFormatterTest {
    static final String INCORRECT_DATE = "32-MAY";

    private DateTimeFormatter underTest;

    @Nested
    @DisplayName("Given ROMAN_FULL")
    class RomanFullDate {
        @BeforeEach
        void setUp() {
            underTest = DateFormatter.ROMAN_FULL_DATE;
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

        @Test
        @DisplayName("when parse incorrect date then throws DateTimeParseException")
        void incorrectDate() {
            assertThrows(DateTimeParseException.class, () -> underTest.parse(INCORRECT_DATE));
        }
    }

    @Nested
    @DisplayName("Given ROMAN_SHORT")
    class RomanShortDate {
        @BeforeEach
        void setUp() {
            underTest = DateFormatter.ROMAN_SHORT_DATE;
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

        @Test
        @DisplayName("when parse incorrect date then throws DateTimeParseException")
        void incorrectDate() {
            assertThrows(DateTimeParseException.class, () -> underTest.parse(INCORRECT_DATE));
        }

    }

    @Nested
    @DisplayName("Given ORDINAL_SHORT")
    class OrdinalShortDate {
        @BeforeEach
        void setUp() {
            underTest = DateFormatter.ORDINAL_SHORT_DATE;
        }

        @ParameterizedTest(name = "when format {0} then {1}")
        @CsvFileSource(resources = "/format/ordinal-short.csv", numLinesToSkip = 1)
        void formatShortOrdinal(final MonthDay date, final String expected) {
            assertEquals(expected, underTest.format(date));
        }

        @ParameterizedTest(name = "when parse {1} then {0}")
        @CsvFileSource(resources = "/format/ordinal-short.csv", numLinesToSkip = 1)
        void parseShortOrdinal(final MonthDay expected, final String roman) {
            final var actual = underTest.parse(roman, MonthDay::from);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("when parse incorrect date then throws DateTimeParseException")
        void incorrectDate() {
            assertThrows(DateTimeParseException.class, () -> underTest.parse(INCORRECT_DATE));
        }

    }

    @Nested
    @DisplayName("Given ORDINAL_FULL")
    class OrdinalFullDate {
        @BeforeEach
        void setUp() {
            underTest = DateFormatter.ORDINAL_FULL_DATE;
        }

        @ParameterizedTest(name = "when format {0} then {1}")
        @CsvFileSource(resources = "/format/ordinal-full.csv", numLinesToSkip = 1)
        void formatFullOrdinal(final LocalDate date, final String expected) {
            assertEquals(expected, underTest.format(date));
        }

        @Test
        @DisplayName("when parse incorrect date then throws DateTimeParseException")
        void incorrectDate() {
            assertThrows(DateTimeParseException.class, () -> underTest.parse(INCORRECT_DATE));
        }

    }
}