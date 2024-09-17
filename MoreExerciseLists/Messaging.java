package MoreExerciseLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Messaging {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numberSequence = collectUserInput(scanner);

        //is blank space considered an index? yes, apparently
        String message = getMessage(scanner);

        List<Integer> sums = getSumOfDigitsOfEachElement(numberSequence);
        String result = findIndexForEachSumInMessage(sums, message);
        System.out.println(result);
    }

    private static String findIndexForEachSumInMessage(List<Integer> sums, String message) {
        List<Character> formedWord = new ArrayList<>();

        char symbol = ' ';
        for (int i = 0; i < message.length(); i++) {
            for (Integer sum : sums) {
                int index = sum;

                while (index >= message.length()) {
                    index -= message.length();
                }

                symbol = message.charAt(index);
                formedWord.add(symbol);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(listToString(formedWord));

        return sb.toString();
    }

    private static String listToString(List<Character> list) {
        StringBuilder sb = new StringBuilder();
        for (Character character : list) {
            sb.append(character);
        }
        return sb.toString();
    }

    private static List<Integer> getSumOfDigitsOfEachElement(List<Integer> numberSequence) {
        List<Integer> sums = new ArrayList<>();

        int sum = 0;
        for (Integer element : numberSequence) {
            String value = String.valueOf(element);
            char[] currentElementDigits = value.toCharArray();
            for (char currentElementDigit : currentElementDigits) {
                sum += Character.getNumericValue(currentElementDigit);
            }
            sums.add(sum);
            sum = 0;
        }
        return sums;
    }


    private static String getMessage(Scanner scanner) {
        return scanner.nextLine();
    }

    private static ArrayList<Integer> collectUserInput(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
    }
}
