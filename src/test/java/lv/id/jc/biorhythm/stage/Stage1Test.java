package lv.id.jc.biorhythm.stage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class Stage1Test {
    final InputStream originalIn = System.in;
    final PrintStream originalOut = System.out;
    final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setIn(originalIn);
    }

    @Test
    @Disabled
    void main() {
        final var in = new ByteArrayInputStream("1970-06-07\n".getBytes());
        System.setIn(in);
        Stage1.main(null);
        assertTrue(out.toString().contains("birth"));
    }
}