package MethodsLaB;

import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int repetitions = Integer.parseInt(scanner.nextLine());
        printTriangle(repetitions);
    }

    private static void printTriangle(int repetitions) {
        printIncreasingNumbers(repetitions);
        printDecreasingNumbers(repetitions);
    }

    private static void printDecreasingNumbers(int repetitions) {
        int newIteration = repetitions - 1;

        for (int i = newIteration; i >= 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    private static void printIncreasingNumbers(int repetitions) {
        for (int i = 0; i <= repetitions; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
