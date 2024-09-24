package MethodsExercises;

import java.sql.Array;
import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        int[] nums = {a, b, c};
        int smallest = findSmallest(nums);
        printResult(smallest);
    }

    private static void printResult(int smallest) {
        System.out.println(smallest);
    }

    private static int findSmallest(int[] nums) {
        int smallest = 0;
        for (int num : nums) {
            if (num < smallest) {
                smallest = num;
            }
        }

        return smallest;
    }
}
