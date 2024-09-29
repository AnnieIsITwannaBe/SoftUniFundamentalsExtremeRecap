package ExamPreparation.RandomizedJudge.MidExamRandom;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> items =
                Arrays.stream(scanner.nextLine().split(",\\s+")).collect(Collectors.toCollection(ArrayList::new));

        String input = scanner.nextLine();
        handleCrafting(input, items, scanner);
    }

    private static void handleCrafting(String input, List<String> items, Scanner scanner) {
        while (!input.equals("Craft!")) {
            String[] tokens = input.split("\\s+-\\s+");
            String command = tokens[0];
            String item = tokens[1];


            switch (command) {
                case "Collect":
                    handleCollect(items, item);
                    break;

                case "Drop":
                    handleDrop(items, item);
                    break;

                case "Combine":
                    handleCombine(tokens, items, item);
                    break;

                case "Renew":
                    handleRenew(items, item);
                    break;

            }
            input = scanner.nextLine();
        }
    }

    private static void handleRenew(List<String> items, String item) {
        if (contains(items, item)) {
            items.remove(item);
            items.addLast(item);
        }
    }

    private static void handleCombine(String[] tokens, List<String> items, String item) {
        String newItem = tokens[2];

        if (contains(items, item)) {
            int indexOfOldItem = items.indexOf(item);
            items.add(indexOfOldItem + 1, newItem);
        }
    }

    private static void handleDrop(List<String> items, String item) {
        items.remove(item);
        //optional operation, removes it only if it is present
    }

    private static void handleCollect(List<String> items, String item) {
        if (!contains(items, item)) {
            items.add(item);
        }
    }

    private static boolean contains(List<String> items, String item) {
        return items.contains(item);
    }
}
