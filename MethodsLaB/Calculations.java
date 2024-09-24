package MethodsLaB;

import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int result = getResult(command, a, b);

        System.out.println(result);
    }

    private static int getResult(String command, int a, int b) {
        return switch (command) {
            case "add" -> a + b;
            case "multiply" -> a * b;
            case "subtract" -> a - b;
            case "divide" -> a / b;
            default -> 0;
        };
    }
}
