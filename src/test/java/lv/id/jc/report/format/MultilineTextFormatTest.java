package lv.id.jc.report.format;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.text.Format;
import java.text.ParseException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Tag("Formatter")
@DisplayName("MultilineTextFormat should")
class MultilineTextFormatTest {
    private static final String SAMPLE_TEXT = "The quick brown fox jumps over the lazy dog";

    private Format underTest;

    private static Stream<Arguments> provideTestData() {
        return Stream.of(
                Arguments.of(10, "The quick\nbrown fox\njumps over\nthe lazy\ndog\n"),
                Arguments.of(15, "The quick brown\nfox jumps over\nthe lazy dog\n"),
                Arguments.of(20, "The quick brown fox\njumps over the lazy\ndog\n"),
                Arguments.of(50, "The quick brown fox jumps over the lazy dog\n"),
                Arguments.of(60, "The quick brown fox jumps over the lazy dog\n")
        );
    }

    @MethodSource("provideTestData")
    @ParameterizedTest(name = "formats text with maximum width {0} symbols")
    void formatWidthTen(int width, String expected) {
        underTest = new MultilineTextFormat(width);
        assertEquals(expected, underTest.format(SAMPLE_TEXT));
    }

    @MethodSource("provideTestData")
    @ParameterizedTest(name = "parse multiline text with width {0} to the single line text")
    void parseObject(int width, String source) throws ParseException {
        underTest = new MultilineTextFormat();
        assertEquals(SAMPLE_TEXT, underTest.parseObject(source));
    }
}