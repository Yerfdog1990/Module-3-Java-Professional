package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.example.LegacyStringCompressor.compressString;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("When compressing a String")
public class CompressStringTest {
    @Test
    @DisplayName("Compressing an empty String")
    public void testEmptyString() {
        assertEquals("", compressString(""));
    }

    @Test
    @DisplayName("Compressing a single character")
    public void testSingleCharacterString() {
        assertEquals("a", compressString("a"));
    }

    @Test
    @DisplayName("Compressing a String with no character repetitions")
    public void testNoRepetition() {
        assertEquals("abcdef", compressString("abcdef"));
    }

    @Test
    @DisplayName("Compress a String with character repetitions")
    public void testRepetition() {
        assertEquals("a2b1c5a3", compressString("aabcccccaaa"));
    }

    @Test
    public void testSpecialCharacters() {
        assertEquals("aa$$bb", compressString("aa$$bb"));
    }

    @Test
    public void testLargeInput() {
        String input = "a".repeat(1000);
        String expected = "a1000";
        assertEquals(expected, compressString(input));
    }

}
