package MethodsMoreExercises;

import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String dataType = scanner.nextLine();
        String input = scanner.nextLine();

        input = switch (dataType) {
            case "int" -> handleIntType(input);
            case "double" -> handleDoubleType(input);
            case "string" -> handleStringResult(input);
            default -> input;
        };

        formatOutput(input);
    }

    private static void formatOutput(String input) {
        System.out.println(input);
    }

    private static String handleStringResult(String input) {
        return "$" + input + "$";
    }

    private static String handleDoubleType(String input) {
        double num = Double.parseDouble(input);

        return String.format("%.2f", num * 1.5);
    }

    private static String handleIntType(String input) {
        int num = Integer.parseInt(input);
        return String.valueOf(num * 2);
    }
}
