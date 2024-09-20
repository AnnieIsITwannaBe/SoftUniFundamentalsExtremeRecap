package AssociativeArraysExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarmingRemastered {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine().toLowerCase();
        boolean hasWinner = false;
        Map<String, Integer> itemsObtained = new LinkedHashMap<>();
        putContentInCorrectOrder(itemsObtained);

        processInput(hasWinner, line, itemsObtained);

        printFinalResult(itemsObtained);
    }

    private static void printFinalResult(Map<String, Integer> itemsObtained) {
        itemsObtained.forEach((v, k) -> System.out.printf("%s -> %d%n", v, k));
        //here apparently we can do that because there is no entry set, check a minerTask for clarification
        //on this note
    }

    private static void putContentInCorrectOrder(Map<String, Integer> itemsObtained) {
        itemsObtained.put("shards", 0);
        itemsObtained.put("fragments", 0);
        itemsObtained.put("motes", 0);
    }

    private static void processInput(boolean hasWinner, String line, Map<String, Integer> itemsObtained) {
        while (!hasWinner) {
            String[] tokens = line.split("\\s+");
            for (int i = 0; i < tokens.length - 1; i++) {
                int quantity = Integer.parseInt(tokens[i]);
                String resource = tokens[i + 1].toLowerCase();

                itemsObtained.putIfAbsent(resource, quantity);
                itemsObtained.put(resource, itemsObtained.get(resource) + quantity);

                if (resource.equals("shards") || resource.equals("fragments") || resource.equals("motes")) {
                    if (itemsObtained.get(resource) + quantity >= 250) {
                        hasWinner = true;
                        determineWinner(resource);
                        buyLegendaryItem(itemsObtained, resource, quantity);
                    }
                }
            }
        }
    }

    private static void buyLegendaryItem(Map<String, Integer> itemsObtained, String resource, int quantity) {
        itemsObtained.put(resource, itemsObtained.get(resource) - quantity);
    }

    private static void determineWinner(String resource) {
        switch (resource) {
            case "shards":
                System.out.println("sh neshtoto");
                break;
            case "fragments":
                System.out.println(" drugo neshto");
                break;
            case "motes":
                System.out.println("treto neshto");
                break;
        }
    }
}
