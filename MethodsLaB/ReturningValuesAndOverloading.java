package MethodsLaB;

import java.util.Scanner;

public class ReturningValuesAndOverloading {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());
        int area = calculateRectangleArea(width, length);
        printFormat(area);
    }

    private static void printFormat(int area) {
        System.out.println(area);
    }

    private static int calculateRectangleArea(int width, int length) {
        return width * length;
    }
}
