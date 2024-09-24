package MethodsLaB;

import javax.management.ObjectName;
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        String operation = scanner.nextLine();
        int b = Integer.parseInt(scanner.nextLine());
        int result = switch (operation) {
            case "/" -> divideNumbers(a, b);
            case "+" -> addNumbers(a, b);
            case "-" -> subtractNumbers(a, b);
            default -> 0;
        };

        printFormat(result);

    }

    private static void printFormat(int result) {
        System.out.println(result);
    }

    private static int subtractNumbers(int a, int b) {
        return a - b;
    }

    private static int addNumbers(int a, int b) {
        return a + b;
    }

    private static int divideNumbers(int a, int b) {
        return a / b;
    }
}
