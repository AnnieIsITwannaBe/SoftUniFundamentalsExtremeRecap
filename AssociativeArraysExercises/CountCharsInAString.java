package AssociativeArraysExercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        //think about the case when it's not going to be just one single word-> "" without this
        //think about the case when it's a lot of words
        //make it an array
        //then use a for(loop) and check each result

        Map<Character, Integer> charOccurrences = countCharsInText(text);

        printCharOccurrences(charOccurrences);
    }

    private static void printCharOccurrences(Map<Character, Integer> charOccurrences) {
        for (Map.Entry<Character, Integer> entry : charOccurrences.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
    }

    private static Map<Character, Integer> countCharsInText(String text) {
        Map<Character, Integer> charOccurrences = new HashMap<>();
        char[] charArray = text.toCharArray();

        for (char c : charArray) {
            if (!charOccurrences.containsKey(c)) {
                charOccurrences.put(c, 1);
            } else {
                Integer currentCount = charOccurrences.get(c);
                charOccurrences.put(c, currentCount + 1);
            }
        }
        return charOccurrences;
    }
}
