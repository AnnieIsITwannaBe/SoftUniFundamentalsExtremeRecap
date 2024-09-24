package MethodsExercises;

import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        int sum = addition(a, b);
        int result = subtract(sum, c);
        printFormat(result);
    }

    private static void printFormat(int result) {
        System.out.println(result);
    }

    private static int subtract(int sum, int c) {
        return sum - c;
    }

    private static int addition(int a, int b) {
        return a + b;
    }
}
