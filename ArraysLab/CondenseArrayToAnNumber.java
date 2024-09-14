package ArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToAnNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = getInput(scanner);

        condenseArrayToSingleDigit(nums);

    }

    private static void condenseArrayToSingleDigit(int[] nums) {
        int[] newArray = new int[nums.length - 1];

        do {
            for (int i = 0; i <= nums.length; i++) {
                newArray[i] = nums[i] + nums[i + 1];

            }

        } while (newArray.length == 1);

    }

    private static int[] getInput(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
