package biorhytms;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertSame;

class ConditionTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/conditions.csv", numLinesToSkip = 1)
    void of(final double percent, final Condition expected) {
        assertSame(expected, Condition.of(percent));
    }
}