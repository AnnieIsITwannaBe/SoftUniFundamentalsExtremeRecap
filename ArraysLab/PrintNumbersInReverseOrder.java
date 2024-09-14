package ArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintNumbersInReverseOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(scanner.nextLine());
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            System.out.print(nums[i] + " ");
        }

        modifyArrayInPlace(nums);

        //we can also modify the array in-place:
    }

    private static void modifyArrayInPlace(int[] nums) {
        int left = 0; // startPointer-a
        int right = nums.length - 1; //endPointer-a

        while (left < right) {
            //this conditions ensures that it will continue as long as the left is less than the right
            //when they become equal this means that we have swapped all of the elements
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}
