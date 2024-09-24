package MethodsExercises;

import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();

        char start = a.charAt(0);
        char end = b.charAt(0);
        for (char i = (char) (start + 1); i < end; i++) {
            System.out.print(i + " ");
        }

    }
}
