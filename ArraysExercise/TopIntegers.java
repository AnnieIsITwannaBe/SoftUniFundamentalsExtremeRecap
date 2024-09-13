package ArraysExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sequence = getUserInput(scanner);

        List<Integer> topIntegers = findTopIntegersInSequence(sequence);
        printFormat(topIntegers);
    }

    private static void printFormat(List<Integer> topIntegers) {
        StringBuilder sb = new StringBuilder();
        sb.append(listToString(topIntegers));
        System.out.println(sb.toString().trim()); //to remove trailing space
        //trailing space refers to any whitespace characters
    }

    private static String listToString(List<?> list) {
        StringBuilder sb = new StringBuilder();
        for (Object value : list) {
            sb.append(value).append(" ");
        }
        return sb.toString();
    }

    private static List<Integer> findTopIntegersInSequence(int[] sequence) {
        List<Integer> topIntegers = new ArrayList<>();

        boolean isBigger = true;
        for (int i = 0; i < sequence.length; i++) {
            isBigger = true; // Reset isBigger for each element
            for (int j = i + 1; j < sequence.length; j++) {
                if (sequence[i] <= sequence[j]) {
                    isBigger = false;
                    break;
                }
                //Now, the isBigger variable is correctly reset to
                // true at the beginning of each iteration of the outer loop,
                // ensuring that each element is properly evaluated for inclusion in the topIntegers list.
            }

            if (isBigger) {
                topIntegers.add(sequence[i]);
            }
        }

        return topIntegers;
    }

    private static int[] getUserInput(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
