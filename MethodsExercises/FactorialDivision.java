package MethodsExercises;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        long aFactorial = getFactorial(a);
        long bFactorial = getFactorial(b);
        long result = divideAtoB(aFactorial, bFactorial);
        printFormat(result);
    }

    private static void printFormat(long result) {
        System.out.println(result);
    }

    private static long divideAtoB(long aFactorial, long bFactorial) {
        return aFactorial / bFactorial;
    }

    private static long getFactorial(int num) {
        long factorial = 1;
        int i = 0;
        while (i <= num) {
            factorial *= i;
            i++;
        }

        return factorial;
    }
}
