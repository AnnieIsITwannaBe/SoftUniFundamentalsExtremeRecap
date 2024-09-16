package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class OrdersAgain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfOrders = Integer.parseInt(scanner.nextLine());

        double priceCurrentOrder;
        double priceForAllOrders = 0.0;
        for (int i = 0; i < numberOfOrders; i++) {
            double pricePerCapsule = Double.parseDouble(scanner.nextLine());
            int daysInMonth = Integer.parseInt(scanner.nextLine());
            int capsuleCount = Integer.parseInt(scanner.nextLine());

            priceCurrentOrder = ((daysInMonth * capsuleCount) * pricePerCapsule);
            System.out.printf("The price for the coffee is $%.2f", priceCurrentOrder);
            priceForAllOrders += priceCurrentOrder;

        }

        System.out.println();
        System.out.printf("Total: $%.2f", priceForAllOrders);
    }
}
