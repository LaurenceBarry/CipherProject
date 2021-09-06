package com.laurencebarry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ShiftCipherTest {

  @Test
  public void testS0ShouldReturnOriginalString() {
      String input = "Original String";
      assertEquals(input, ShiftCipher.encode(input, 0));
  }

  @Test
  public void testS1SingleLetterShouldReturnNextLetter() {
      String input = "A";
      assertEquals("B", ShiftCipher.encode(input, 1));
  }

  @Test
  public void testS2SingleLetterShouldReturnNextButOneLetter() {
      String input = "A";
      assertEquals("C", ShiftCipher.encode(input, 2));
  }

  @Test
  public void testS1ABShouldReturnBC() {
      String input = "AB";
      assertEquals("BC", ShiftCipher.encode(input, 1));
  }

  @Test
  public void testWrappingUpperCaseLettersEitherEndOfTheAlphabet() {
      assertEquals("YZA", ShiftCipher.encode("XYZ", 1));
      assertEquals("YZA", ShiftCipher.encode("ABC", -2));
  }

  @Test
  public void testWrappingLowerCaseLettersEitherEndOfTheAlphabet() {
    assertEquals("yza", ShiftCipher.encode("xyz", 1));
    assertEquals("yza", ShiftCipher.encode("abc", -2));
  } 

  @Test
  public void testRoundTrip() {

    // Encode a string and then re-encode the result with a negative
    // shift - the result should match the original string
    String input = "The quick brown fox jumps over the lazy dog";
    int shift = 3;

    String encoded = ShiftCipher.encode(input, shift);
    assertEquals(input, ShiftCipher.encode(encoded, Math.negateExact(shift)));
  } 
}
