package MoreExerciseLists;

import java.util.*;
import java.util.stream.Collectors;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> first = readInput(scanner);
        List<Integer> second = readInput(scanner);

        List<Integer> merged;

        if (first.size() > second.size()) {
            merged = handleFirstLogic(first, second);
        } else {
            merged = handleSecondLogic(first, second);
        }

        Collections.sort(merged);
        printFormat(merged);

    }

    private static ArrayList<Integer> readInput(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
    }

    private static List<Integer> handleFirstLogic(List<Integer> first, List<Integer> second) {
        List<Integer> list = new ArrayList<>();

        int[] range = defineRangeFirst(first);
        int start = range[0];
        int end = range[1];

        for (int i = start; i < end; i++) {
            for (int j = 0; j < first.size(); j++) {
                if (first.get(j) > start && first.get(j) < end) {
                    list.add(first.get(j));
                    break;
                }
            }

            for (int k = second.size() - 1; k > 0; k--) {
                if (second.get(k) > start && second.get(k) < end) {
                    list.add(second.get(k));
                    break;
                }
            }


        }

        //When you use break in a nested loop in Java, it will only exit the innermost
        // loop where the break statement is executed. The control flow will then move to the next statement following the inner loop.

        return list;
    }

    private static int[] defineRangeFirst(List<Integer> first) {
        int[] rangeStartEnd = new int[2];
        int last = first.get(first.size() - 1);
        int secondLast = first.get(first.size() - 2);

        if (last < secondLast) {
            rangeStartEnd[0] = last;
            rangeStartEnd[1] = secondLast;
        } else {
            rangeStartEnd[0] = secondLast;
            rangeStartEnd[1] = last;
        }

        return rangeStartEnd;
    }

    private static List<Integer> handleSecondLogic(List<Integer> first, List<Integer> second) {
        List<Integer> list = new ArrayList<>();

        int[] range = defineRangeSecond(second);

        int start = range[0];
        int end = range[1];

        for (int i = start; i < end; i++) {
            for (int j = 0; j < first.size(); j++) {
                if (second.get(j) > start && second.get(j) < end) {
                    list.add(first.get(j));
                    break;
                }
            }

            for (int k = second.size() - 1; k > 0; k--) {
                if (second.get(k) > start && second.get(k) < end) {
                    list.add(second.get(k));
                    break;
                }
            }


        }
        return list;
    }

    private static int[] defineRangeSecond(List<Integer> list) {
        int[] range = new int[2];
        int first = list.get(0);
        int second = list.get(1);

        if (first < second) {
            range[0] = first;
            range[1] = second;
        } else {
            range[0] = second;
            range[1] = first;
        }

        return range;
    }

    private static void printFormat(List<Integer> merged) {
        StringBuilder sb = new StringBuilder();
        sb.append(listToString(merged));
        System.out.println(sb.toString());
    }

    private static String listToString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append(" ");
        }

        return sb.toString();
    }


}
