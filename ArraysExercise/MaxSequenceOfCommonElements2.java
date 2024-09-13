package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfCommonElements2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] elements = getInput(scanner);
        int[] data = findMaxElement(elements);
        printFormat(data);
    }

    private static void printFormat(int[] maxElementSequence) {
        int length = maxElementSequence[1];
        for (int i = 0; i < length; i++) {
            System.out.print(maxElementSequence[0] + " ");

        }
    }

    private static int[] findMaxElement(int[] elements) {
        int currentLength = 0;
        int maxLength = 0;

        int[] data = new int[2];

        int maxElement = 0;
        int currentElement = elements[0];

        for (int i = 0; i < elements.length - 1; i++) {
            if (elements[i] == elements[i + 1]) {
                currentLength++;
            } else {
                currentLength = 1;
                currentElement = elements[i];
            }
            if (currentLength > maxLength) {
                maxLength = currentLength;
                maxElement = elements[i];
            }
        }

        if (currentLength > maxLength) {
            maxLength = currentLength;
            maxElement = currentElement;
        }

        data[0] = maxElement;
        data[1] = maxLength;


        return data;
    }

    private static int[] getInput(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
