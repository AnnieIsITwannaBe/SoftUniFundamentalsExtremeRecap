package AssociativeArraysExercises;

import java.util.*;

public class OrdersRemastered {
    //i've like always wondered what is a linkage error? make sure to check this out:
    //https://www.jetbrains.com/help/idea/compiling-applications.html -> check his out
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        //мноого ама многоо важен въпрос, как можем да го достъпим този лист с double-и
        //на нулева позиция държим цената, а на първа количеството

        Map<String, List<Double>> productPriceAllocation = attachNameToPrice(line, scanner);

        printOutput(productPriceAllocation);
    }

    private static void printOutput(Map<String, List<Double>> productPriceAllocation) {

    }

    private static Map<String, List<Double>> attachNameToPrice(String line, Scanner scanner) {
        Map<String, List<Double>> productPriceAllocation = new LinkedHashMap<>();
        while (!line.equals("buy")) {
            String[] tokens = line.split("\\s+");
            String productName = tokens[0];
            Double price = Double.parseDouble(tokens[1]);
            Double quantity = Double.parseDouble(tokens[2]);

            //аз мисля, че добре е написано, но моля те все пак го провери за всеки случай
            productPriceAllocation.putIfAbsent(productName, new ArrayList<>(List.of(price, quantity)));
            //in case it exists:
            productPriceAllocation.get(productName).set(0, price);

            productPriceAllocation.get(productName).set(1, productPriceAllocation.get(productName).get(1) + quantity);
            //първо трябва да update-нем цената, като цената само си я рисетваме на новото количество
            //но когаго трябва да update-нем количеството, ще трябва да дотъпим досегашното количество
            //и да добавим новото към него, а това колега е златен въпрос?
            //eg: prodcts.get(prodictName).get(1) + quantity

//            List<Double> priceAndQuantity = productPriceAllocation.get(productName);
//            productPriceAllocation.put(productName,
//                    new ArrayList<>(List.of(productPriceAllocation.get(productName)
//                            .set(1, priceAndQuantity.get(1) + quantity))));

            line = scanner.nextLine();
        }
        return productPriceAllocation;
    }
}
