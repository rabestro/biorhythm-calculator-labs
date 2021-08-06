package report.format;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.text.Format;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("MultilineTextFormat should")
class MultilineTextFormatTest {
    private static final String SAMPLE1 = "The quick brown fox jumps over the lazy dog";

    private Format underTest;

    private static Stream<Arguments> provideWidthAndStrings() {
        return Stream.of(
                Arguments.of(10, "The quick\nbrown fox\njumps over\nthe lazy\ndog"),
                Arguments.of(20, "The quick brown fox\njumps over the lazy\ndog"),
                Arguments.of(50, "The quick brown fox jumps over the lazy dog"),
                Arguments.of(60, "The quick brown fox jumps over the lazy dog")
        );
    }

    @BeforeEach
    void setUp() {
    }

    @MethodSource("provideWidthAndStrings")
    @ParameterizedTest(name = "formats text with maximum width {0} symbols")
    void formatWidthTen(int width, String expected) {
        underTest = new MultilineTextFormat(width);

        val actual = underTest.format(SAMPLE1);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("throws UnsupportedOperationException on parseObject call")
    void parseObject() {
        underTest = new MultilineTextFormat();
        assertThrows(UnsupportedOperationException.class, () -> underTest.parseObject(SAMPLE1));
    }
}