package MethodsExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SplittableRandom;

public class TopNumber2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        int intRepresentation = Integer.parseInt(n);
        List<Integer> numbersInRange = getAllNumbersInRange(intRepresentation);

        List<Integer> topNumbers = findTopNumbers(numbersInRange);
        printFormat(topNumbers);


    }

    private static void printFormat(List<Integer> topNumbers) {
        String representation = listToString(topNumbers);
        System.out.println(representation);

    }

    private static String listToString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (Integer integer : list) {
            sb.append(integer);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    private static List<Integer> findTopNumbers(List<Integer> numbersInRange) {
        boolean containEnoughOddDigits;
        boolean isDivisible;
        List<Integer> topNumbers = new ArrayList<>();
        for (int i = 0; i < numbersInRange.size(); i++) {
            int currentDigitSum = getSumOfDigits(numbersInRange, i);
            isDivisible = isDivisibleByTargetNums(currentDigitSum);
            containEnoughOddDigits = containsSufficientOddNumbers(i);

            if (isDivisible && containEnoughOddDigits) {
                topNumbers.add(numbersInRange.get(i));
            }
        }

        return topNumbers;
    }

    private static boolean containsSufficientOddNumbers(int i) {
        char[] digits = getCharArrayRepresentation(i);
        int oddDigitsCount = 0;
        if (digits.length == 1) {
            if (Character.getNumericValue(digits[0]) % 3 == 0) {
                oddDigitsCount++;
            }
        } else {
            for (int j = 0; j < digits.length - 1; j++) {
                if (Character.getNumericValue(digits[i]) % 3 == 0) {
                    oddDigitsCount++;
                }
            }
        }
        return oddDigitsCount >= 2;

    }

    private static char[] getCharArrayRepresentation(int i) {
        String number = String.valueOf(i);

        return number.toCharArray();
    }

    private static boolean isDivisibleByTargetNums(int currentDigitSum) {
        if (currentDigitSum % 88 == 0) {
            return true;
        }

        if (currentDigitSum % 16 == 0) {
            return true;
        }

        return currentDigitSum % 8 == 0;
    }


    //weak point discovered: how to convert integer to string: String.valueOf
    private static int getSumOfDigits(List<Integer> numbersInRange, int i) {
        char[] digits = getCharArrayRepresentation(i);
        int sum = 0;
        for (char digit : digits) {
            sum += Character.getNumericValue(digit);
        }

        return sum;
    }

    private static List<Integer> getAllNumbersInRange(int intRepresentation) {
        List<Integer> allNumbersInRange = new ArrayList<>();
        for (int i = 1; i < intRepresentation; i++) {
            allNumbersInRange.add(i);
        }

        return allNumbersInRange;
    }
}
