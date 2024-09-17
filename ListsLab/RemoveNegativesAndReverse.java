package ListsLab;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numberSequence = collectUserInput(scanner);

        List<Integer> negativeFreeSequence = removeNegatives(numberSequence);
        if (negativeFreeSequence.isEmpty()) {
            System.out.println("empty");
        }
        String result = reverseModifiedSequence(negativeFreeSequence);
        printFormatResult(result);
    }

    private static void printFormatResult(String result) {
        System.out.println(result);
    }

    private static String reverseModifiedSequence(List<Integer> negativeFreeSequence) {
        Collections.reverse(negativeFreeSequence);
        StringBuilder sb = new StringBuilder();
        sb.append(listToString(negativeFreeSequence));


        return sb.toString();
    }

    private static String listToString(List<Integer> nums) {
        StringBuilder sb = new StringBuilder();
        for (Integer num : nums) {
            sb.append(num).append(" ");
        }

        return sb.toString();
    }

    private static List<Integer> removeNegatives(List<Integer> numberSequence) {
        for (int i = 0; i < numberSequence.size(); i++) {
            if (numberSequence.get(i) < 0) {
                numberSequence.remove(numberSequence.get(i));
            }
        }
        return numberSequence;
    }

    private static ArrayList<Integer> collectUserInput(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
    }
}
