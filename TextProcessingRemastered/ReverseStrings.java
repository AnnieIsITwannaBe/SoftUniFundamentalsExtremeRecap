package TextProcessingRemastered;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        Map<String, String> wordsReversed = handleReverse(line, scanner);

        wordsReversed.forEach((key, value) -> {
            System.out.printf("%s -> %s%n", key, value);
        });
    }

    private static Map<String, String> handleReverse(String line, Scanner scanner) {
        Map<String, String> wordsReversed = new LinkedHashMap<>();
        while (!line.equals("end")) {
            String word = line;
            String reversedWord = getReversedWord(word);

            wordsReversed.putIfAbsent(word, reversedWord);

            line = scanner.nextLine();
        }
        return wordsReversed;
    }

    private static String getReversedWord(String word) {
        StringBuilder sb = new StringBuilder();
        char[] wordChars = word.toCharArray();

        for (int i = wordChars.length - 1; i > 0; i--) {
            sb.append(wordChars[i]);
        }
        return sb.toString();
    }
}
