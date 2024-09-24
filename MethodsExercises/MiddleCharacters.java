package MethodsExercises;

import com.sun.security.auth.NTSidUserPrincipal;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();

        char[] indexesOfMiddleCharacter = findMiddleCharacter(text);
        printFormat(indexesOfMiddleCharacter);

    }

    private static void printFormat(char[] indexesOfMiddleCharacter) {
        System.out.println(charArrayToString(indexesOfMiddleCharacter));
    }

    private static String charArrayToString(char[] array) {
        StringBuilder sb = new StringBuilder();
        for (char c : array) {
            sb.append(c);
        }
        return sb.toString();
    }

    private static char[] findMiddleCharacter(String text) {
        char[] symbols = text.toCharArray();
        int mid = symbols.length / 2;
        int mid2 = 0;

        if (symbols.length % 2 == 0) {
            mid2 = mid - 1;
            return new char[]{symbols[mid], symbols[mid2]};
        }

        return new char[]{symbols[mid]};
    }
}
