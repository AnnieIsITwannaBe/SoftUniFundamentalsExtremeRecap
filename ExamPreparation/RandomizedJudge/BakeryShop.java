package ExamPreparation.RandomizedJudge;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class BakeryShop {
    private static final String NOT_ENOUGH_IN_STOCK_MESSAGE = "There aren't enough %s. You sold the last %d of them.";
    private static final String SOLD_PRODUCT_IN_STOCK = "You sold %d %s.";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        Map<String, Integer> foodRecord = new LinkedHashMap<>();

        int allSalesCount = 0;
        allSalesCount = historyOfTransactions(line, foodRecord, allSalesCount, scanner);

        System.out.println(allSalesCount);
        foodRecord.forEach((key, value) -> System.out.printf("%s : %d", key, value));
    }

    private static int historyOfTransactions(String line, Map<String, Integer> foodRecord, int allSalesCount, Scanner scanner) {
        while (!line.equals("Complete")) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];

            int quantity = Integer.parseInt(tokens[1]);
            String food = tokens[2];


            switch (command) {
                case "Receive":
                    handleReceivingProcess(foodRecord, food, quantity);
                    break;

                case "Sell":
                    allSalesCount = handleSellingProcess(foodRecord, food, quantity, allSalesCount);
                    break;
            }
            line = scanner.nextLine();
        }
        return allSalesCount;
    }

    private static int handleSellingProcess(Map<String, Integer> foodRecord, String food, int quantity, int allSalesCount) {
        if (!isInStock(foodRecord, food)) {
            System.out.println("no food in inventory");
        } else {
            //unnecessary unboxing intValue?
            boolean isOutOfStock = foodRecord.get(food) < 0;

            Integer currentAvailableAmount = foodRecord.get(food);
            if (currentAvailableAmount < quantity) {
                //currentAvailableAmount - currentAvailableAmount == 0 anyway
                foodRecord.remove(food); //because it's out of stock
                System.out.printf(NOT_ENOUGH_IN_STOCK_MESSAGE, food, currentAvailableAmount);
                allSalesCount += currentAvailableAmount;
            } else {
                foodRecord.put(food, currentAvailableAmount - quantity);
                if (isOutOfStock) {
                    foodRecord.remove(food);
                }
                System.out.printf(SOLD_PRODUCT_IN_STOCK, quantity, food);
                allSalesCount += quantity;
            }
        }
        return allSalesCount;
    }

    private static boolean isInStock(Map<String, Integer> foodRecord, String food) {
        return foodRecord.containsKey(food);
    }

    private static void handleReceivingProcess(Map<String, Integer> foodRecord, String food, int quantity) {
        if (!isInStock(foodRecord, food)) {
            foodRecord.put(food, quantity);
        } else {
            Integer currentAvailableQuantity = foodRecord.get(food);
            currentAvailableQuantity = updateQuantityInStock(currentAvailableQuantity, quantity);
            foodRecord.put(food, currentAvailableQuantity);
        }
    }

    private static Integer updateQuantityInStock(Integer currentAvailableQuantity, int quantity) {
        currentAvailableQuantity += quantity;
        return currentAvailableQuantity;
    }
}
//Your code for the "BakeryShop" problem is well-structured and demonstrates a good understanding of basic programming concepts. Here's a detailed breakdown and rating of your code:
//
//### **1. Code Structure and Organization (4.5/5)**
//- **Pros:**
//  - The code is well-organized with clear methods for each task (`handleReceivingProcess`, `handleSellingProcess`, `isInStock`, `updateQuantityInStock`, etc.).
//  - The use of constants for messages (`NOT_ENOUGH_IN_STOCK_MESSAGE`, `SOLD_PRODUCT_IN_STOCK`) is good practice as it makes the code more maintainable and readable.
//  - The main method is clean and focuses on orchestrating the flow rather than handling too many details.
//
//- **Cons:**
//  - The method `historyOfTransactions` could be better named as something like `processTransactions` for clarity, as it doesn't just record history but processes commands as well.
//
//### **2. Code Efficiency (4/5)**
//- **Pros:**
//  - The code handles inventory management efficiently with basic operations on the map.
//  - The use of `LinkedHashMap` is appropriate since it maintains the insertion order, which could be useful depending on how you want to display the results.
//
//- **Cons:**
//  - There’s a slight inefficiency in the method `handleSellingProcess` where you check if an item is out of stock after already removing it from the inventory. This check could be redundant.
//  - The unboxing of integers when handling the quantity can be avoided to keep the code a bit cleaner, though it doesn’t have a significant impact on performance.
//
//### **3. Error Handling (3.5/5)**
//- **Pros:**
//  - The code correctly handles cases where there is insufficient stock or no stock at all, providing appropriate messages to the user.
//
//- **Cons:**
//  - There is a logical error in `handleSellingProcess`: the variable `isOutOfStock` is set before any operations are done, making its purpose unclear. The check seems unnecessary because if you are already reducing the quantity, the condition should be updated accordingly.
//  - It could benefit from handling invalid input cases, such as non-integer quantities or malformed commands.
//
//### **4. Readability and Maintainability (4.5/5)**
//- **Pros:**
//  - The code is highly readable, with each method clearly defined and well-named, making it easy to understand what each part of the code is doing.
//  - The use of comments and descriptive variable names improves clarity.
//
//- **Cons:**
//  - Some minor improvements could be made to method names (e.g., `historyOfTransactions` could be more descriptive).
//
//### **5. Correctness and Functionality (4/5)**
//- **Pros:**
//  - The code seems to handle all the functionality required by the problem, including adding stock, selling products, and checking inventory levels.
//  - The output messages are consistent with the requirements.
//
//- **Cons:**
//  - The print statement in the `handleSellingProcess` method that handles out-of-stock situations might not fully match the logic when the stock is exactly zero. This could lead to an edge case where the logic might not work as intended.
//  - Also, there should be a space after `value` when printing in `foodRecord.forEach((key, value) -> System.out.printf("%s : %d", key, value));` to match typical output formatting.
//
//### **Overall Rating: 4.1/5**
//
//**Summary:** Your code is well-structured and generally efficient, with strong readability and organization. The main area for improvement lies in the `handleSellingProcess` method, where logic can be refined to avoid redundant checks and handle edge cases more effectively. Additionally, enhancing error handling for user input could make the code more robust. Overall, this is a solid implementation that meets the problem's requirements well.