package lv.id.jc.biorhythm.ui;

import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

@Tag("UI")
@DisplayName("Given TextInterface")
class TextInterfaceTest {
    private final PrintStream originalOut = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    private TextInterface underTest;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(out));

        underTest = new TextInterface() {};
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("when println() then prints line separator")
    void println() {
        underTest.println();
        assertEquals(System.lineSeparator(), out.toString());
    }

    @Test
    @DisplayName("when print() then prints using MessageFormat")
    void print() {
        underTest.print("Hello, {0}!", "World");
        assertEquals("Hello, World!", out.toString());
    }

    @Test
    @DisplayName("when println() then prints using MessageFormat")
    void testPrintln() {
        final var expected = "Hello, World!" + System.lineSeparator();
        underTest.println("Hello, {0}!", "World");
        assertEquals(expected , out.toString());
    }
}