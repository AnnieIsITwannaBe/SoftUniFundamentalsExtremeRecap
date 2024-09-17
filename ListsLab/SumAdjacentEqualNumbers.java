package ListsLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));

        List<Integer> adulterated = sumAdjacentEqualNumbers(numbers);
        printFormat(adulterated);
    }

    private static void printFormat(List<Integer> adulterated) {
        for (Integer number : adulterated) {
            System.out.print(number + " ");
        }
    }

    private static List<Integer> sumAdjacentEqualNumbers(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            if (numbers.get(i).equals(numbers.get(i + 1))) {
                numbers.set(i, numbers.get(i) + numbers.get(i + 1));
                numbers.remove(numbers.get(i + 1));
            }
        }
        return numbers;
    }
}
