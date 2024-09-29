package ExamPreparation.RandomizedJudge.MidExamFebruary2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> initialList =
                Arrays.stream(scanner.nextLine().split("!")).collect(Collectors.toCollection(ArrayList::new));

        String line = scanner.nextLine();
        List<String> finalDecision = modifyDraft(line, initialList, scanner);

        //handle how not to print , when using stream
        finalDecision.forEach(item -> System.out.printf("%s,", item));
    }

    private static List<String> modifyDraft(String line, List<String> initialList, Scanner scanner) {
        while (!line.equals("Go Shopping")) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Urgent":
                    handleUrgent(tokens, initialList);
                    break;

                case "Unnecessary":
                    handleUnnecessary(tokens, initialList);
                    break;

                case "Correct":
                    handleCorrect(tokens, initialList);
                    break;

                case "Rearrange":
                    handleRearrange(tokens, initialList);
                    break;

            }
            line = scanner.nextLine();
        }

        return initialList;
    }

    private static void handleRearrange(String[] tokens, List<String> initialList) {
        String toBeAddedAtTheBack = tokens[1];

        boolean contains = checkAvailability(initialList, toBeAddedAtTheBack);
        if (contains) {
            initialList.remove(toBeAddedAtTheBack);
            initialList.addLast(toBeAddedAtTheBack);
        }
    }

    private static void handleCorrect(String[] tokens, List<String> initialList) {
        String oldItem = tokens[1];
        String newItem = tokens[2];

        boolean contains = checkAvailability(initialList, oldItem);

        if (contains) {
            int replaceProductIndex = initialList.indexOf(oldItem);
            initialList.add(replaceProductIndex, newItem);
            initialList.remove(oldItem);
            // // 0 1 2 3 4  this way we will conserve the order correctly because the old one will shft
            //with one o the right and then when we delete it, the new one will remain in place and the
            //movements of the other elements will be handled accordingly without affecting its index
        }
    }

    private static void handleUnnecessary(String[] tokens, List<String> initialList) {
        String unnecessaryItem = tokens[1];

        boolean contains = checkAvailability(initialList, unnecessaryItem);
        if (!contains) {
            initialList.remove(unnecessaryItem);
        }
    }

    private static boolean checkAvailability(List<String> initialList, String unnecessaryItem) {
        return initialList.contains(unnecessaryItem);
    }

    private static void handleUrgent(String[] tokens, List<String> initialList) {
        String firstPriorityItem = tokens[1];

        //this could have been done with the contains thingy as well
        String preexistingItem =
                initialList.stream().filter(item -> item.equals(firstPriorityItem))
                        .findFirst().orElse(null);


        boolean isNotPresent = preexistingItem == null;
        if (isNotPresent) {
            initialList.addFirst(firstPriorityItem);
        } else {
            //is this really necessary? maybe no
            return;
        }
    }
}
