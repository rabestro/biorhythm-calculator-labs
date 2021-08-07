package lv.id.jc.biorhythm.format;

import lombok.val;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.text.Format;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@Tag("Formatter")
class PrettyListFormatTest {
    private Format underTest;

    @BeforeEach
    void setUp() {
        underTest = new PrettyListFormat();
    }

    @Test
    @DisplayName("empty list")
    void emptyListTest() {
        val list = List.of();

        val expected = "";
        val actual = underTest.format(list);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("list that contains one null element")
    void listWithOneNullTest() {
        val list = Collections.singletonList(null);

        val expected = "";
        val actual = underTest.format(list);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("list with one items")
    void oneItemsTest() {
        val list = List.of("item");

        val expected = "item";
        val actual = underTest.format(list);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("list with two items")
    void twoItemsTest() {
        val list = List.of("apple", "banana");

        val expected = "apple and banana";
        val actual = underTest.format(list);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("list with one item and null")
    void oneAndNullItemsTest() {
        val list = new ArrayList<String>() {{
            add("apple");
            add(null);
        }};

        val expected = "apple";
        val actual = underTest.format(list);

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("list with four items")
    void fourItemsTest() {
        val list = List.of("a", "b", "c", "d");

        val actual = underTest.format(list);
        val expected = "a, b, c and d";

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("list with three elements and null")
    void nullItemsTest() {
        val list = new ArrayList<>() {{
            add("a");
            add("b");
            add(null);
            add("c");
        }};

        val actual = underTest.format(list);
        val expected = "a, b and c";

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("list with two elements and one empty and one null")
    void emptyAndNullItemsTest() {
        val list = new ArrayList<>() {{
            add("apple");
            add("banana");
            add(null);
            add("");
        }};

        val actual = underTest.format(list);
        val expected = "apple and banana";

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("throws UnsupportedOperationException on parseObject call")
    void parseObject() {
        assertThrows(UnsupportedOperationException.class, () -> underTest.parseObject("apple and banana"));
    }
}