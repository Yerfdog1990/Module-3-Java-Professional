package org.example;

public class StringCompressor {
  public static String compressString(
      String input) { // E.g: input = "aaabbbbcdrr" output = a3b4cdr2
    //handle null or empty input
    if (input == null || input.isEmpty()) {
      return "";
    }
    int count = 1;
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i < input.length(); i++) {
      if (input.charAt(i) == input.charAt(i - 1)) {
        count++;
      } else {
        sb.append(input.charAt(i - 1));
        if (count > 1) {
          sb.append(count);
        }
        count = 1;
      }
    }
    sb.append(input.charAt(input.length() - 1));
    if (count > 1) {
      sb.append(count);
    }
    return sb.toString();
  }

  private static void testCompressString(String input, String expected) {
    String output = compressString(input);
    System.out.println("Input: " + input + " \nExpected: " + expected + " \nOutput: " + output);
    boolean testPassed = output.equals(expected);
    if (!testPassed) {
      throw new AssertionError("Test failed!");
    }else {
      System.out.println("Test passed!");
    }
  }

  // Main method
  public static void main(String[] args) {
    testCompressString("", ""); // Test for empty string
    testCompressString(null, ""); // Test for null input
    testCompressString("a", "a"); // Test for single character input
    testCompressString("aartaa", "a2rta2"); // Test for repeated characters compressing to count
    testCompressString("abc", "abc"); // Test for input with no repetitions
    testCompressString("aabbcc", "a2b2c2"); // Test for input with multiple groups of repeating characters
  }
}
