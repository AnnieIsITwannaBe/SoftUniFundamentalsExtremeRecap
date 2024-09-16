package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.*;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Double> acceptedCoins = Set.of(0.1, 0.2, 0.5, 1.0, 2.0);
        String input = scanner.nextLine();
        double sumOfCoins = 0;

        while (!input.equals("Start")) {
            try {
                double coin = Double.parseDouble(input);
                if (acceptedCoins.contains(coin)) {
                    sumOfCoins += coin;
                } else {
                    System.out.printf("Cannot accept %.2f", coin);
                    System.out.println();
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please insert valid coins.");
                System.out.println();
            }

            input = scanner.nextLine();
        }

        Map<String, Double> productPrices = populateProductPrices();
        double totalBill = 0.0;
        input = scanner.nextLine();
        while (!input.equals("End")) {
            String product = input;
            if (productPrices.containsKey(product)) {
                double pricePerProduct = productPrices.get(product);

                if (sumOfCoins >= pricePerProduct) {
                    sumOfCoins -= pricePerProduct;
                    totalBill += pricePerProduct;
                    System.out.println("Purchased " + product);
                } else {
                    System.out.println("Sorry, not enough money!");
                }
            } else {
                System.out.println("Invalid product!");
            }

            if (totalBill > sumOfCoins) {
                System.out.println("Sorry, not enough money!");
            }

            input = scanner.nextLine();
        }

        if (sumOfCoins > 0) {
            System.out.printf("Change: %.2f", sumOfCoins);
        }
    }


    private static Map<String, Double> populateProductPrices() {
        Map<String, Double> productPrices = new HashMap<>();
        productPrices.put("Nuts", 2.0);
        productPrices.put("Water", 0.7);
        productPrices.put("Crisps", 1.5);
        productPrices.put("Soda", 1.0);

        return productPrices;
    }
}
