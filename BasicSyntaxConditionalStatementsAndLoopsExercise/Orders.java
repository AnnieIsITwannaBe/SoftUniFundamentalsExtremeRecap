package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Double, List<Integer>> data = processInputIntoUsableData(scanner);
        double totalPrice = calculatePrice(data);
    }

    private static double calculatePrice(Map<Double, List<Integer>> data) {
        double totalPrice = 0.0;
        for (Map.Entry<Double, List<Integer>> map : data.entrySet()) {
            double pricePerCapsule = map.getKey();
            List<Integer> info = map.getValue();
            int days = info.get(0);
            int capsulesCount = info.get(1);
            totalPrice = ((days * capsulesCount) * pricePerCapsule);
        }

        return totalPrice;
    }

    private static Map<Double, List<Integer>> processInputIntoUsableData(Scanner scanner) {
        int numberOfOrders = Integer.parseInt(scanner.nextLine());
        Map<Double, List<Integer>> dataForPriceCalculation = new HashMap<>();
        List<Integer> daysAndCapsulesCount;

        for (int i = 1; i <= numberOfOrders; i++) {
            double pricePerCapsule = Double.parseDouble(scanner.nextLine());
            int days = Integer.parseInt(scanner.nextLine());
            int capsulesCount = Integer.parseInt(scanner.nextLine());
            daysAndCapsulesCount = getList(days, capsulesCount);
            dataForPriceCalculation.put(pricePerCapsule, daysAndCapsulesCount);
        }

        return dataForPriceCalculation;
    }


    private static List<Integer> getList(int days, int capsulesCount) {
        List<Integer> daysAndCount = new ArrayList<>();
        daysAndCount.add(days);
        daysAndCount.add(capsulesCount);

        return daysAndCount;
    }
}
