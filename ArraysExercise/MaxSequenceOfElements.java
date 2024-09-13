package ArraysExercise;

import java.util.*;

public class MaxSequenceOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] sequence = scanner.nextLine().split("\\s+");

        findLongestSequence(sequence);
    }

    private static void findLongestSequence(String[] sequence) {
        Map<Integer, String> sequencesFound = new HashMap<>();
        List<String> current = new ArrayList<>();

        for (int i = 0; i < sequence.length; i++) {
            if (sequence[i].equals(sequence[i + 1])) {


            }

        }
    }
}
