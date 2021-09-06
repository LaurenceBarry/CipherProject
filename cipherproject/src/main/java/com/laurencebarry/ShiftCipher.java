package com.laurencebarry;

public class ShiftCipher {

    public static String encode(String input, int shift) {
      if (shift == 0) {
        return input;
      } else {
        return shiftString(input, shift);
      }
    }

    private static String shiftString(String input, int shift) {
      StringBuffer sb = new StringBuffer();

      for (char ch: input.toCharArray()) {
        if (Character.isLetter(ch)) { // only encrypt letters
          char letter = (char)(ch + shift);
          sb.append(wrap(letter, Character.isLowerCase(ch)));
        } else {
          sb.append(ch);
        }
      }
      return sb.toString();
    }

    // Wrap the output letter if the shift pushes off the end of the
    // alphabet
    // ASCII A = 65, Z = 90, a = 97, z = 122
    private static char wrap(char letter, boolean lowerCase) {

      if ((lowerCase && letter > 'z') || (!lowerCase && letter > 'Z')) {
        letter -= 26;
      } else if ((lowerCase && letter < 'a') || (!lowerCase && letter < 'A')) {
        letter += 26;
      }
      return letter;
    }
}
