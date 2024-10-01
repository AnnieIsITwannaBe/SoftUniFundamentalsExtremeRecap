package TextProcessingRemastered;

import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("\\s+");

        StringBuilder newWord = new StringBuilder();
        for (String word : words) {
            String repeated = repeat(word);
            newWord.append(repeated);
        }

        System.out.println(newWord);
    }

    private static String repeat(String word) {
        return word.repeat(word.length());
    }
}
