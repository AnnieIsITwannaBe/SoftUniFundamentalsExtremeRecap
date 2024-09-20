package AssociativeArraysExercises.OrderUsingObjectsAndClasses;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Order {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //this can be solved using objects and classes as well

        List<Product> productList = new LinkedList<>();

        String line = scanner.nextLine();
        while (!line.equals("buy")) {
            String[] tokens = line.split("\\s+");
            String name = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            int quantity = Integer.parseInt(tokens[2]);

            Product product = new Product(name, price, quantity);
            productList.add(product);


            line = scanner.nextLine();
        }
    }
}
