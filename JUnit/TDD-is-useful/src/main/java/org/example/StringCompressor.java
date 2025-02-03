package org.example;

public class StringCompressor {
  public static String compressString(String input) {
    if (input.isEmpty()) return "";

    int counter = 1;

    StringBuilder sb = new StringBuilder();

    for(int i = 1; i < input.length(); i++) {
      char current = input.charAt(i);
      char previous = input.charAt(i - 1);

      if (current == previous) {
        counter++;
      } else {
        if (counter > 1) {
          sb.append(previous);
          sb.append(counter);
          counter = 1;
        } else sb.append(previous);
      }
    }

    sb.append(input.charAt(input.length() - 1));
    if (counter > 1) sb.append(counter);

    return sb.toString();
  }

  private static void test(String input, String expected) {
    String actual = compressString(input);
    boolean correct = expected.equals(actual);
    System.out.println("input: " + input + ", expected: " + expected + ", actual: " + actual);
    if (!correct) System.out.println("Test failed");
  }

  public static void main(String[] args){
    // aabbbcdeeff -> a2b3cde2f
    test("aabbbcdeeff", "a2b3cde2f2");
    // test("", "");
    test("a", "a");
    test("aa", "a2");
    test("abccdd", "abc2d2");
  }
}
