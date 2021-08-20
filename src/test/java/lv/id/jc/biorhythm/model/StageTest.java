package lv.id.jc.biorhythm.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

@Tag("Model")
@DisplayName("Given Stage enum")
class StageTest {

    @DisplayName("then it have exactly five constants")
    @Test
    void hasFiveConstants() {
        final var expected = 5;
        assertEquals(expected, Stage.values().length);
    }

    @ParameterizedTest(name = "when {0} then is positive {1}")
    @CsvFileSource(resources = "/model/stage.csv", numLinesToSkip = 1)
    void isPositive(final Stage stage, final boolean expected) {
        assertEquals(expected, stage.isPositive());
    }

}