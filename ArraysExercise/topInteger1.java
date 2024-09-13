package ArraysExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class topInteger1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sequence = Arrays.stream(scanner.nextLine()
                .split(" ")).mapToInt(Integer::parseInt).toArray();

        List<Integer> topIntegers = findTopIntegersInSequence(sequence);
        printFormat(topIntegers);
    }

    private static void printFormat(List<Integer> topIntegers) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(listToString(topIntegers));
        System.out.println(stringBuilder.toString());

    }

    private static String listToString(List<?> list) {
        StringBuilder sb = new StringBuilder();
        for (Object value : list) {
            sb.append(value).append(" ");
        }

        return sb.toString();
    }

    private static List<Integer> findTopIntegersInSequence(int[] sequence) {
        List<Integer> topIntegers = new ArrayList<>();

        int current = 0;
        boolean isBigger = true;

        while (current < sequence.length) {
            for (int i = current + 1; i < sequence.length - 1; i++) {
                if (sequence[current] <= sequence[i + 1]) {
                    isBigger = false;
                    break;
                }
            }

            if (isBigger) {
                topIntegers.add(sequence[current]);

            }

            current++;

        }

        return topIntegers;


    }
}
