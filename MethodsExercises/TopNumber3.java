package MethodsExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TopNumber3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        boolean isDivisible;
        boolean containsEnoughOddDigits;

        List<Integer> numbersInRange = new ArrayList<>();
        for (int i = 1; i < number; i++) {
            numbersInRange.add(i);
        }

        List<Integer> topNumbers = new ArrayList<>();

        for (int i = 0; i < numbersInRange.size(); i++) {
            int currentNumber = numbersInRange.get(i);
            int currentSum = getSumOfDigits(currentNumber);
            isDivisible = checkSumDivisibleByTargetNums(currentSum);
            containsEnoughOddDigits = checkNumberOfOddDigits(currentNumber);
            if (isDivisible && containsEnoughOddDigits) {
                topNumbers.add(currentNumber);
            }
        }

        printFormat(topNumbers);
    }

    private static void printFormat(List<Integer> topNumbers) {
        String output = listToString(topNumbers);
        System.out.println(output);
    }

    private static String listToString(List<?> list) {
        StringBuilder sb = new StringBuilder();
        for (Object o : list) {
            sb.append(o);
            sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

    private static boolean checkNumberOfOddDigits(int currentNumber) {
        char[] digits = getCharRepresentation(currentNumber);
        int oddCount = 0;

        for (char digit : digits) {
            if (Character.getNumericValue(digit) % 2 != 0) {
                oddCount++;
            }
            //numbers divided by 3 that are equal to 0 are not necessarily odd
        }

        return oddCount >= 2;
    }

    private static boolean checkSumDivisibleByTargetNums(int currentSum) {
        if (currentSum % 88 == 0) {
            return true;
        }

        if (currentSum % 16 == 0) {
            return true;
        }

        return currentSum % 8 == 0;
    }

    private static int getSumOfDigits(int currentNumber) {
        char[] digits = getCharRepresentation(currentNumber);

        int sum = 0;
        for (char digit : digits) {
            sum += Character.getNumericValue(digit);
        }
        return sum;
    }

    private static char[] getCharRepresentation(int currentNumber) {
        String representation = String.valueOf(currentNumber);

        return representation.toCharArray();
    }
}
