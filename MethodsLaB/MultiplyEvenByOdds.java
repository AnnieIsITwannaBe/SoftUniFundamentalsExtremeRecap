package MethodsLaB;

import java.util.Scanner;

public class MultiplyEvenByOdds {
    public static void main(String[] args) {
        char[] digits = processUserInput();
        int result = multiplyEvenByOdds(digits);
        printFormat(result);
    }

    private static void printFormat(int result) {
        System.out.println(result);
    }

    private static char[] processUserInput() {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();

        return number.toCharArray();
    }

    private static int multiplyEvenByOdds(char[] digits) {
        int evenSum = 0;
        int oddSum = 0;
        for (char digit : digits) {
            if (Character.getNumericValue(digit) % 2 == 0) {
                evenSum += Character.getNumericValue(digit);
            } else {
                oddSum += Character.getNumericValue(digit);
            }
        }

        return evenSum * oddSum;
    }
}
