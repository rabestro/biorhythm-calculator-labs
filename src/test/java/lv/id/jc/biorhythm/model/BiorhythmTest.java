package lv.id.jc.biorhythm.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@Tag("Model")
@DisplayName("Given Biorhythm enum")
class BiorhythmTest {

    @DisplayName("then it have exactly seven constants")
    @Test
    void hasTwelveSigns() {
        final var expectedSigns = 7;
        assertEquals(expectedSigns, Biorhythm.values().length);
    }


}