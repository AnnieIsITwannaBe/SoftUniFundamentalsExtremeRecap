package ListsLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));

        List<Integer> adulteratedList = modifyNumbers(numbers);
        getPrintFormat(adulteratedList);
    }

    private static void getPrintFormat(List<Integer> adulteratedList) {
        for (Integer num : adulteratedList) {
            System.out.print(num + " ");
        }
    }

    private static List<Integer> modifyNumbers(List<Integer> numbers) {
        List<Integer> adulteratedList = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            adulteratedList.add(numbers.get(i) + numbers.get(numbers.size() - 1 - i));
        }

        return adulteratedList;
    }
}
