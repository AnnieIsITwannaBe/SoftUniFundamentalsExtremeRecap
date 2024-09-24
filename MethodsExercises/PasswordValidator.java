package MethodsExercises;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        validatePassword(password);
    }

    private static void validatePassword(String password) {
        if (!lengthIsInRange(password)) {
            System.out.println("Password must be between 6 and 10 characters");
        }
        //check if there are only letters and digits:
        validatePasswordContentValidity(password);

        //check if there are at least 2 digits
        validateNumberOfDigits(password);
    }

    private static void validateNumberOfDigits(String password) {
        int numberOfDigits = 0;
        for (int i = 0; i < password.length(); i++) {
            char currentSymbol = password.charAt(i);
            if (Character.isDigit(currentSymbol)) {
                numberOfDigits++;
            }
        }

        if (numberOfDigits < 2) {
            System.out.println("Password must have at least 2 digits");
        }
    }

//    private static void validatePasswordContentValidity(String password) {
//        for (int i = 0; i < password.length(); i++) {
//            char currentSymbol = password.charAt(i);
//
//            if (currentSymbol > 33 && currentSymbol < 64) {
//                System.out.println("Password must consist only of letters and digits");
//                break;
//            }
//        }
//    }

    private static void validatePasswordContentValidity(String password) {
        boolean illegalCharacterFound = false;
        for (int i = 0; i < password.length(); i++) {
            char currentChar = password.charAt(i);

            if (!(Character.isLetter(currentChar)) && !((Character.isDigit(currentChar)))) {
                illegalCharacterFound = true;
                break;
            }


        }
        if (illegalCharacterFound) {
            System.out.println("Password must consist only of letters and digits");
        }

    }

    private static boolean lengthIsInRange(String password) {
        return password.length() >= 6 && password.length() <= 10;
    }
}
