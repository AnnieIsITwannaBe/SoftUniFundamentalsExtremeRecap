package ArraysExercise;

import java.util.*;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = getUserInput(scanner);

        findMaxSequenceOfNumbers(numbers);
    }


    //currentSequence.add(String.valueOf(numbers[i]));
    //                currentSequence.add(String.valueOf(numbers[i + 1]));
    private static void findMaxSequenceOfNumbers(int[] numbers) {
        Set<List<String>> sequences = new HashSet<>();

        String sequence = " ";
        int currentCounter = 0;
        String currentElement = " ";
        List<String> currentSequence = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            boolean sequenceDetected = true;
            if (numbers[i] != numbers[i + 1]) {
                sequenceDetected = false;
                break;
            } else {
                currentCounter++;
                currentElement = String.valueOf(numbers[i]);
            }


        }


    }

    private static int[] getUserInput(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
