package AssociativeArraysExercises;

import java.util.*;

public class OrdersRemastered2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> products = allocatePriceToProduct(scanner);

        //поради някаква причина има getFirstMethod wtf?
        handleOutput(products);
    }

    private static void handleOutput(Map<String, List<Double>> products) {
        products.forEach((k, v) -> System.out.printf("%s -> %.2f%n", k, v.getFirst() * v.get(1)));
    }

    private static Map<String, List<Double>> allocatePriceToProduct(Scanner scanner) {
        Map<String, List<Double>> products = new LinkedHashMap<>();
        String line = scanner.nextLine();
        while (!line.equals("buy")) {
            String[] tokens = line.split("\\s+");
            String name = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            double quantity = Double.parseDouble(tokens[2]);

            //you can also do this by using the put if absent variant
            if (products.containsKey(name)) {
                products.get(name).set(0, price);
                products.get(name).set(1, products.get(name).get(1) + quantity);
            } else {
                products.put(name, new ArrayList<>(List.of(price, quantity)));
            }
            line = scanner.nextLine();
        }

        return products;
    }
}
