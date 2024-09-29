package ExamPreparation.RandomizedJudge.FinalExamRetakeOctober2020;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        Pattern pattern = Pattern.compile("([#@])(?<wordOne>[A-Z][a-z]+)\\1\\1(?<wordTwo>[a-z]+[A-Z])\\1");

        Matcher matcher = pattern.matcher(line);

        Map<String, String> mirrored = extractValidPairs(matcher);

        System.out.println("Mirrored words are: ");

        //figure out how to put a in the middle to separate them
        //grazie professional plugin

        mirrored.forEach((key, value) -> System.out.printf("%s <=> %s", key, value));
    }

    private static Map<String, String> extractValidPairs(Matcher matcher) {
        Map<String, String> mirrored = new LinkedHashMap<>();
        while (matcher.find()) {
            String wordOne = matcher.group("wordOne");
            String wordTwo = matcher.group("wordTwo");

            if (mirrors(wordTwo, wordOne)) {
                mirrored.putIfAbsent(wordOne, wordTwo);
            }
        }
        return mirrored;
    }

    private static boolean mirrors(String wordTwo, String wordOne) {
        StringBuilder stringBuilder = new StringBuilder(wordOne);
        stringBuilder.reverse();

        String reversed = stringBuilder.toString();

        return reversed.equals(wordTwo);

    }
}
