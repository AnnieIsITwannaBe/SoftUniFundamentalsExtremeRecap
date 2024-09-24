package MethodsExercises;

import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        int vowelsCount = countVowelsInText(text, vowels);
        printResult(vowelsCount);
    }

    private static void printResult(int vowelsCount) {
        System.out.println(vowelsCount);
    }

    private static int countVowelsInText(String text, char[] vowels) {
        char[] allLetters = text.toCharArray();
        int vowelCount = 0;
        for (char allLetter : allLetters) {
            for (char vowel : vowels) {
                if (Character.toLowerCase(allLetter) == vowel) {
                    vowelCount++;
                }
            }
        }
        return vowelCount;
    }
}
