package ArraysLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SumEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = readUserInput(scanner);
        List<Integer> evenValues = new ArrayList<>();
        for (int number : numbers) {
            if (number % 2 == 0) {
                evenValues.add(number);
            }
        }

        printValues(evenValues);
    }

    private static void printValues(List<Integer> evenValues) {
        StringBuilder sb = new StringBuilder();
        sb.append(listToString(evenValues));
        System.out.println(sb);

    }

    private static String listToString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(" ");

        }

        return sb.toString();
    }

    private static int[] readUserInput(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}
