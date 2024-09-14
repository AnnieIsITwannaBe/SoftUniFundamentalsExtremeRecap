package ArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] first = getInput(scanner);
        int[] second = getInput(scanner);

        if (first.length > second.length || first.length < second.length) {
            System.out.println("Arrays are not equal in size!");
        }

        boolean areEqual = true;
        int index = 0;
        int sum = 0;

        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < second.length; j++) {
                if (first[j] == second[j]) {
                    sum += second[j];
                } else {
                    areEqual = false;
                    index = j;
                    break;
                }
            }
        }

        if (!areEqual) {
            System.out.printf("Arrays are not identical. Found difference at %d index.", index);
        } else {
            System.out.printf("Arrays are identical. Sum: %d", sum / 2);
        }
    }

    private static int[] getInput(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
