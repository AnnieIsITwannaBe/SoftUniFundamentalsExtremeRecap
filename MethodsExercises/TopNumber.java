package MethodsExercises;

import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        int sum = getDigitsSum(number);
        boolean isDivisible = checkDivisibleByTargetSums(sum);

        boolean hasEnoughOddDigits = checkAvailabilityOfOddDigits(number);

        if (isDivisible && hasEnoughOddDigits) {

        }


    }

    private static boolean checkAvailabilityOfOddDigits(String number) {
        int oddDigitsCount = 0;
        char[] digits = number.toCharArray();

        for (char digit : digits) {
            if (Character.getNumericValue(digit) % 3 == 0) {
                oddDigitsCount++;
            }

        }
        return oddDigitsCount >= 2;
    }

    private static boolean checkDivisibleByTargetSums(int sum) {
        if (sum % 88 == 0) {
            return true;
        }
        if (sum % 16 == 0) {
            return true;
        }
        return sum % 8 == 0;
    }

    private static int getDigitsSum(String number) {
        char[] digits = number.toCharArray();
        int sum = 0;

        for (char digit : digits) {
            sum += Character.getNumericValue(digit);
        }

        return sum;
    }
}
