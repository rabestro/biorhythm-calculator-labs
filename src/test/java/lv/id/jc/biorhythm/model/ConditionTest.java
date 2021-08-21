package lv.id.jc.biorhythm.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@Tag("Model")
@DisplayName("Given Condition enum")
class ConditionTest {

    @DisplayName("then it have exactly six constants ")
    @Test
    void hasSixConstants() {
        final var expected = 6;
        assertEquals(expected, Condition.values().length);
    }

    @ParameterizedTest(name = "when percent is {0}% then condition is {1}")
    @CsvFileSource(resources = "/model/conditions.csv", numLinesToSkip = 1)
    void of(final double percent, final Condition expected) {
        assertSame(expected, Condition.of(percent));
    }
}