package TextProcessingRemastered;

import java.util.Scanner;

public class DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //we'll have to use some regex here:
        String input = scanner.nextLine();
        String numbers = findAllNumbers(input);
        String letters = findAllLetters(input);
        //discover a way to find out about the characters¶
    }

    private static String findAllLetters(String input) {
        String numbers = " ";
        char[] sequence = input.toCharArray();

        for (char c : sequence) {
            if (!Character.isDigit(c)) {
                numbers = String.valueOf(c);
            }
        }
        return numbers;
    }

    private static String findAllNumbers(String input) {
        String numbers = " ";
        char[] sequence = input.toCharArray();

        for (char c : sequence) {
            if (Character.isDigit(c)) {
                numbers = String.valueOf(c);
            }
        }

        return numbers;

    }
}
