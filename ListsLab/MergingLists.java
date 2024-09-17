package ListsLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //be careful because one of them might be smaller than the other
        List<Integer> first = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
        List<Integer> second = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));

        List<Integer> merged = mergeLists(first, second);
        printFormat(merged);
    }

    private static void printFormat(List<Integer> merged) {
        for (Integer num : merged) {
            System.out.print(num + " ");
        }
    }

    private static List<Integer> mergeLists(List<Integer> first, List<Integer> second) {
        List<Integer> merged = new ArrayList<>();

        for (int i = 0; i < first.size(); i++) {
            merged.add(first.get(i));
            for (int j = i; j < second.size(); j++) {
                merged.add(second.get(j));
                break;

            }
        }
        return merged;
    }
}
