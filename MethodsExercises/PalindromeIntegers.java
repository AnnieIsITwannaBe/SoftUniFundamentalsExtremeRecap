package MethodsExercises;

import org.apache.commons.lang3.ArrayUtils;

import java.util.Arrays;
import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            char[] digits = input.toCharArray();
            char[] reversed = reverse(digits);
            checkIfIspalindrome(digits, reversed);


            input = scanner.nextLine();
        }

        //weak points discovered during this session: преговори сравняване на листове
        //преговори също така как да се обърне масив наобратно ин прейс
    }

    private static void checkIfIspalindrome(char[] digits, char[] reversed) {
        if (Arrays.equals(digits, reversed)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }

//    private static void reverse(char[] digits) {
//        ArrayUtils.reverse(digits);
//        //investigate a lot on how to reverse arrays
//    }

    public static char[] reverse(char[] array) {
        char[] newArray = new char[array.length];
        for (int i = 0; i < array.length / 2; i++) {
            char temp = array[i];
            newArray[i] = array[array.length - 1 - i];
            newArray[array.length - 1 - i] = temp;
        }

        return newArray;
    }
}
