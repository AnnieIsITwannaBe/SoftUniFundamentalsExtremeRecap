package ExamPreparation.RandomizedJudge.MidExam052020;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //•	"swap {index1} {index2}" takes two elements and swap their places.
        //•	"multiply {index1} {index2}" takes element at the 1st index and multiply it with the element at 2nd index. Save the product at the 1st index.
        //•	"decrease" decreases all elements in the array with 1.

        int[] numberSequence = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String line = scanner.nextLine();
        while (!line.equals("end")) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "swap":
                    handleSwapping(tokens, numberSequence);
                    break;

                case "multiply":
                    handleMultiply(tokens, numberSequence);
                    break;

                case "decrease":
                    handleDecrease(numberSequence);

                    break;
            }
            line = scanner.nextLine();
        }

        //TODO:
        //print the sequence
    }

    private static void handleDecrease(int[] numberSequence) {
        for (int i = 0; i < numberSequence.length; i++) {
            numberSequence[i] -= 1;
        }
    }

    private static void handleMultiply(String[] tokens, int[] numberSequence) {
        int indexA = Integer.parseInt(tokens[1]);
        int indexB = Integer.parseInt(tokens[2]);

        int result = indexA * indexB;
        numberSequence[0] = result;
    }

    private static void handleSwapping(String[] tokens, int[] numberSequence) {
        int indexA = Integer.parseInt(tokens[1]);
        int indexB = Integer.parseInt(tokens[2]);

        int temp = 0;

        //doing that swappingThingy:
        numberSequence[indexA] = temp;
        numberSequence[indexA] = numberSequence[indexB];
        numberSequence[indexB] = temp;
    }
}
