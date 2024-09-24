package MethodsLaB;

import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());
        double result = returnPowerOfNumber(number, power);
        printFormat(result);
    }

    private static void printFormat(double result) {
        System.out.printf("%.0f", result);
    }

    private static double returnPowerOfNumber(int number, int power) {
        return Math.pow(number, power);
        //why there isn't Math.pow for int
    }
}
