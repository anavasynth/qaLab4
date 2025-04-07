package edu.honchariukvadym;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
  @author  Anavasynth
  @project  IntelliJ IDEA
  @class  RomanToArabicTest
  version 1.0.0
  @since 07.04.2025 - 12.50
*/

public class RomanToArabicTest {

    RomanToArabic converter = new RomanToArabic();

    @Test
    public void testValidRomanI() {
        assertEquals(1, converter.convert("I"));
    }

    @Test
    public void testValidRomanIV() {
        assertEquals(4, converter.convert("IV"));
    }

    @Test
    public void testValidRomanIX() {
        assertEquals(9, converter.convert("IX"));
    }

    @Test
    public void testValidRomanXL() {
        assertEquals(40, converter.convert("XL"));
    }

    @Test
    public void testValidRomanXC() {
        assertEquals(90, converter.convert("XC"));
    }

    @Test
    public void testValidRomanC() {
        assertEquals(100, converter.convert("C"));
    }

    @Test
    public void testValidRomanCM() {
        assertEquals(900, converter.convert("CM"));
    }

    @Test
    public void testValidRomanMCMXCIV() {
        assertEquals(1994, converter.convert("MCMXCIV"));
    }

    @Test
    public void testInvalidRomanCharacter() {
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> converter.convert("ABCD"));
        assertTrue(ex.getMessage().contains("Invalid Roman character"));
    }

    @Test
    public void testInvalidRomanOrder() {
        assertThrows(IllegalArgumentException.class, () -> converter.convert("IC")); // should be invalid
    }
}