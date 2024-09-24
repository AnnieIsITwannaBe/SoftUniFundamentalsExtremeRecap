package MethodsLaB;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        double price = calculatePrice(product, quantity);
        printFormat(price);
    }

    private static void printFormat(double price) {
        System.out.printf("%.2f", price);
    }

    private static double calculatePrice(String product, int quantity) {
        return switch (product) {
            case "coffee" -> quantity * 1.50;
            case "water" -> quantity * 1.00;
            case "coke" -> quantity * 1.40;
            case "snacks" -> quantity * 2.00;
            default -> 0.0;
        };
    }
}
