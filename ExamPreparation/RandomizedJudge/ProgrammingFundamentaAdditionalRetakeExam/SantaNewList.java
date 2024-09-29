package ExamPreparation.RandomizedJudge.ProgrammingFundamentaAdditionalRetakeExam;

import java.util.*;

public class SantaNewList {
    private static final String PRINT_CHILDREN = "Children:";
    private static final String CHILD_PRESENTS_AMOUNT_TEMPLATE = "%s -> %d\n";
    private static final String PRINT_PRESENTS = "Presents:";
    private static final String CATEGORY_AMOUNT_TEMPLATE = "%s -> %d\n";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> kidsPresentsAmount = new LinkedHashMap<>();
        Map<String, Integer> amountPerCategory = new LinkedHashMap<>();

        handleDataProcessing(scanner, kidsPresentsAmount, amountPerCategory);

        handlePrinting(kidsPresentsAmount, amountPerCategory);
    }

    private static void handlePrinting(Map<String, Integer> kidsPresentsAmount, Map<String, Integer> amountPerCategory) {
        kidsPresentsAmount.entrySet().stream().sorted(
                        (a, b) -> {
                            int result = Integer.compare(b.getValue(), a.getValue());

                            if (b.getValue().equals(a.getValue())) {
                                result = a.getKey().compareTo(b.getKey());
                            }

                            return result;
                        })
                .forEach(entry -> System.out.printf(CHILD_PRESENTS_AMOUNT_TEMPLATE, entry.getKey(), entry.getValue()));

        System.out.println(PRINT_PRESENTS);
        amountPerCategory.forEach((key, value) -> System.out.printf(CATEGORY_AMOUNT_TEMPLATE, key, value));
    }

    private static void handleDataProcessing(Scanner scanner, Map<String, Integer> kidsPresentsAmount, Map<String, Integer> amountPerCategory) {
        String line = scanner.nextLine();
        while (!line.equals("END")) {
            String[] tokens = line.split("->");

            if (tokens[0].equals("Remove")) {
                kidsPresentsAmount.remove(tokens[1]);
                return;
            }
            String kidName = tokens[0];
            String desiredPresent = tokens[1];
            int amountOfPresent = Integer.parseInt(tokens[2]);

            updatePresentAmountData(kidsPresentsAmount, kidName, amountOfPresent);

            updateCategoryTotalInventory(amountPerCategory, desiredPresent, amountOfPresent);

            line = scanner.nextLine();
        }
    }

    private static void updateCategoryTotalInventory(Map<String, Integer> amountPerCategory, String desiredPresent, int amountOfPresent) {
        if (!amountPerCategory.containsKey(desiredPresent)) {
            amountPerCategory.put(desiredPresent, amountOfPresent);
        } else {
            int currentAmount = amountPerCategory.get(desiredPresent);
            currentAmount += amountOfPresent;
            amountPerCategory.put(desiredPresent, currentAmount);
        }
    }

    private static void updatePresentAmountData(Map<String, Integer> kidsPresentsAmount, String kidName, int amountOfPresent) {
        updateCategoryTotalInventory(kidsPresentsAmount, kidName, amountOfPresent);
    }
}
////то това е вярно, но трябва да се филтрира СОРТИРА БЕ НАУЧИ СЕ НАЙ-НАКРАЯ по descending order:
////        System.out.println(PRINT_CHILDREN);
////        kidsPresentsAmount.forEach((key, value) -> System.out.printf(CHILD_PRESENTS_AMOUNT_TEMPLATE, key, value));