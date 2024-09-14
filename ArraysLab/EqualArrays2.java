package ArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] first = getArray(scanner);
        int[] second = getArray(scanner);

        if (first.length != second.length) {
            System.out.println("Arrays are simply not equal in size");
        }

        boolean areEqual = true;
        int index = 0;
        int sum = 0;

        for (int i = 0; i < first.length; i++) {
            if (first[i] != second[i]) {
                areEqual = false;
                index = i;
                break;
            } else {
                sum += first[i];
            }
        }

        if (areEqual) {
            System.out.printf("Arrays are identical. Sum: %d", sum);
        } else {
            System.out.printf("Arrays are not identical. Found difference at %d index", index);
        }
    }

    private static int[] getArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
