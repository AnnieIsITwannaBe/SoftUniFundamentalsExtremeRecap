package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfCommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numberSequence = readUserInput(scanner);
        int[] maxElementSequence = findMaxCommonElementSequence(numberSequence);
        printFormat(maxElementSequence);

    }

    private static void printFormat(int[] maxElementSequence) {
        int length = maxElementSequence[1];
        for (int i = 0; i < length; i++) {
            System.out.print(maxElementSequence[0] + " ");

        }
    }

    private static int[] findMaxCommonElementSequence(int[] numberSequence) {
        int currentLength = 0;
        int maxLength = 0;

        int currentNumber = numberSequence[0];
        int maxNumber = 0;
        for (int i = 1; i < numberSequence.length; i++) {
            if (numberSequence[i] == numberSequence[i - 1]) {
                currentLength++;
            } else if (currentLength > maxLength) {
                maxLength = currentLength;
                maxNumber = numberSequence[i];
            }
        }
        // Final comparison for the case when the longest sequence ends at the last element
        if (currentLength > maxLength) {
            maxLength = currentLength;
            maxNumber = currentNumber;
        }
        int[] maxNumberLength = new int[2];
        maxNumberLength[0] = maxNumber;
        maxNumberLength[1] = maxLength;

        return maxNumberLength;
    }

    private static int[] readUserInput(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
