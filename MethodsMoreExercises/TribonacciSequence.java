package MethodsMoreExercises;

import java.util.DoubleSummaryStatistics;
import java.util.Scanner;

public class TribonacciSequence {
    public static void main(String[] args) {
        //driver code
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
    }

    public static int printRec(int n) {
        if (n == 0 || n == 1 || n == 2)
            return 0;

        if (n == 3)
            return 1;

        return printRec(n - 1) + (n - 2) + (n - 3);
    }

    public static void print(int n) {
        for (int i = 1; i < n; i++) {
            System.out.println(printRec(i) + " ");

        }
    }


}
