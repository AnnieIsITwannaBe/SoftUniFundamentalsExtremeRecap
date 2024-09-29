package ExamPreparation.RandomizedJudge.BakeryShopObjectsAndClasses;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BakeryShop {

    private static final String NOT_ENOUGH_IN_STOCK_MESSAGE = "There aren't enough %s. You sold the last %d of them.";

    private static final String SOLD_PRODUCT_IN_STOCK = "You sold %d %s.";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        //това може да бъде решено и с Map, ние ще го направим по двата начина просто ей така за спорта
        List<Inventory> foodRecord = processUserInput(line, scanner);

        //we need to print each and every single one of them and figure out a way with which you'll be able to
        //introduce and return a variable that keeps a score of all the products that were sold during the process
    }

    private static List<Inventory> processUserInput(String line, Scanner scanner) {
        List<Inventory> foodRecord = new LinkedList<>();
        while (!line.equals("Complete")) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Receive":
                    handleReceivingProcess(tokens, foodRecord);
                    break;

                case "Sell":
                    handleSellingProcess(tokens, foodRecord);
                    break;
            }

            line = scanner.nextLine();
        }

        return foodRecord;
    }

    private static void handleSellingProcess(String[] tokens, List<Inventory> foodRecord) {
        int quantity = Integer.parseInt(tokens[1]);
        if (!isValid(quantity)) {
            return;
        }

        String food = tokens[2];

        Inventory sellRequest = new Inventory(food, quantity);

        if (!inStock(foodRecord, sellRequest)) {
            System.out.println("no food in inventory");
        } else {
            Inventory selectedItem = foodRecord.stream().
                    filter(inventory -> inventory.getFood().equals(food)).findFirst().orElse(null);

            assert selectedItem != null;

            boolean isSoldOut = selectedItem.getQuantity() <= 0;
            //if the quantity is exceeding the current in stock quantity
            //remove all the available product and print corresponding message:
            if (selectedItem.getQuantity() < quantity) {
                int currentQuantityInStock = selectedItem.getQuantity();
                selectedItem.setQuantity(selectedItem.getQuantity() - currentQuantityInStock);

                System.out.printf(NOT_ENOUGH_IN_STOCK_MESSAGE, food, currentQuantityInStock);

                foodRecord.remove(selectedItem);
            } else {
                selectedItem.setQuantity(selectedItem.getQuantity() - quantity);
                System.out.printf(SOLD_PRODUCT_IN_STOCK, quantity, food);
                if (isSoldOut) {
                    foodRecord.remove(selectedItem);
                }
            }
        }
    }

    private static boolean inStock(List<Inventory> foodRecord, Inventory targetInventory) {
        return !foodRecord.contains(targetInventory);
    }

    private static void handleReceivingProcess(String[] tokens, List<Inventory> foodRecord) {
        int quantity = Integer.parseInt(tokens[1]);
        if (!isValid(quantity)) {
            return;
        }

        String food = tokens[2];
        Inventory currentInventory = new Inventory(food, quantity);
        if (inStock(foodRecord, currentInventory)) {
            foodRecord.add(currentInventory);
        } else {
            Inventory existingFood = foodRecord.stream().filter(inventory -> inventory.getFood().equals(food)).findFirst().orElse(null);

            assert existingFood != null;

            existingFood.setQuantity(existingFood.getQuantity() + quantity);
        }
    }

    private static boolean isValid(int quantity) {
        return (quantity > 0);
    }
}
