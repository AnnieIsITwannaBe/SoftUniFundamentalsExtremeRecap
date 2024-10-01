package TextProcessingLab;

import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

public class RepeatString2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> input = getUserInput(scanner);

        String result = handleLogic(input);

        printOutput(result);

    }

    private static void printOutput(String result) {
        System.out.println(result);
    }

    private static List<String> getUserInput(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    //i really do not understand why it only takes the last element, besides that it seems to be working
    //make sure to check already solved solution in the problem description document
    private static String handleLogic(List<String> input) {
        String result = " ";
        while (!input.isEmpty()) {
            String currentWord = input.get(0);
            int repetitionRate = currentWord.length();
            result = getRepeatWordByCriteria(currentWord, repetitionRate);

            resetResult(input);
        }

        return result;
    }

    private static void resetResult(List<String> input) {
        input.remove(0);
    }

    private static String getRepeatWordByCriteria(String currentWord, int repetitionRate) {
        return String.valueOf(currentWord).repeat(Math.max(0, repetitionRate));
    }
}
