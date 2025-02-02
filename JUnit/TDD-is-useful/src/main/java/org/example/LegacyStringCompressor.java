package org.example;

public class LegacyStringCompressor {
    private static void runUseCase(String title, String input) {
        String compressedString = compressString(input);
        System.out.println(title + ": " +
                input + " - " +
                compressedString +
                String.format(" [%s]", compressedString.length()));
    }
    public static void main(String[] args) {
        runUseCase("Empty String", "");
        runUseCase("Single character String", "a");
        runUseCase("Some repetition", "aabhcc");
        runUseCase("Some more repetition", "aaaaabbbhcc");
        runUseCase("Some special characters", "$$$cccg||");
    }

    public static String compressString(String input) {
        if (input.isEmpty()) return "";
        if (input.length() == 1) return input;

        StringBuilder compressed = new StringBuilder();
        int count = 1;

        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                compressed.append(input.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        compressed.append(input.charAt(input.length() - 1)).append(count);

        String compressedString = compressed.toString();
        return compressedString.length() >= input.length() ? input : compressedString;
    }
}