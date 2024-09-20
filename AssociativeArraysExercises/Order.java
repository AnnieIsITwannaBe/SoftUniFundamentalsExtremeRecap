package AssociativeArraysExercises;

import java.util.LinkedHashMap;
import java.util.*;

public class Order {
    public static void main(String[] args) {
        //пази информацията за продукти и тяхното количество
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        Map<String, Double> productsPrices = handleProductPriceAllocation(line, scanner);

        printOutput(productsPrices);
    }

    private static void printOutput(Map<String, Double> productsPrices) {
        for (Map.Entry<String, Double> entry : productsPrices.entrySet()) {
            System.out.println(entry.getKey() + String.format("%.2f", entry.getValue()));
        }
    }

    private static Map<String, Double> handleProductPriceAllocation(String line, Scanner scanner) {
        Map<String, Double> productsPrices = new LinkedHashMap<>();
        while (!line.equals("buy")) {
            String[] tokens = line.split("\\s+");
            String name = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            int quantity = Integer.parseInt(tokens[2]);

            if (!productsPrices.containsKey(name)) {
                productsPrices.putIfAbsent(name, price * quantity);
            } else {
                Double currentPrice = productsPrices.get(name);
                productsPrices.put(name, currentPrice + price * quantity);
            }

            line = scanner.nextLine();
        }
        return productsPrices;
    }
}
