package AssociativeArraysLab;

import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        Map<String, Integer> data = allocateClassWithOccurrences(input);

        List<String> targetClasses = getOddOccurringClasses(data);

        printResult(targetClasses);

        // I don't have any idea how to fix this problem, debug this later

    }

    private static void printResult(List<String> targetClasses) {
        System.out.println(listToString(targetClasses).toLowerCase());
    }

    private static String listToString(List<?> list) {
        StringBuilder sb = new StringBuilder();
        for (Object o : list) {
            sb.append(o).append(" ");
        }
        return sb.toString();
    }

    private static List<String> getOddOccurringClasses(Map<String, Integer> data) {
        List<String> oddOccurringClasses = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddOccurringClasses.add(entry.getKey());
            }
        }
        return oddOccurringClasses;
    }

    private static Map<String, Integer> allocateClassWithOccurrences(String[] input) {
        Map<String, Integer> data = new HashMap<>();

        for (String currentOption : input) {
            String toLowerCase = currentOption.toLowerCase();
            if (!data.containsKey(toLowerCase)) {
                data.putIfAbsent(currentOption, 1);
            } else {
                int currentCount = data.get(toLowerCase);
                data.put(currentOption, currentCount + 1);
            }
        }
        return data;
    }
}
