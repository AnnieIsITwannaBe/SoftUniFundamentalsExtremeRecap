package ArraysExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = getUserInput(scanner);
        int targetNumber = Integer.parseInt(scanner.nextLine());
        List<int[]> pairs = findUniquePairs(nums, targetNumber);
        printFormat(pairs);
    }

    private static void printFormat(List<int[]> pairs) {
        StringBuilder sb = new StringBuilder();
        for (int[] pair : pairs) {
            sb.append(pair[0]).append(" ").append(pair[1]).append("\n");
        }
        System.out.print(sb.toString().trim()); // Remove trailing newline
    }

    private static List<int[]> findUniquePairs(int[] nums, int targetNumber) {

        List<int[]> pairs = new ArrayList<>();
        boolean areEqual;
        for (int i = 0; i < nums.length - 1; ) {
            int[] currentPair = new int[2];
            areEqual = nums[i] + nums[i + 1] == targetNumber;

            if (areEqual) {
                currentPair[0] = nums[i];
                currentPair[1] = nums[i + 1];
                pairs.add(currentPair);
                i += 2;
            } else {
                i++;
            }
        }
        return pairs;
    }

    private static int[] getUserInput(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
