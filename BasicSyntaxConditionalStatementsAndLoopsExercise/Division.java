package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.*;

public class Division {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = Integer.parseInt(scanner.nextLine());

        int[] divisionNums = {2, 3, 6, 7, 10};
        Map<Integer, List<Integer>> allDividers = getAllDividers(num, divisionNums);
        int biggestDivider = getBiggestDivider(allDividers);
        printBiggestDivider(biggestDivider);

    }


    private static void printBiggestDivider(int biggestDivider) {
        String finalMessage = "The number is divisible by " + biggestDivider;
        System.out.println(finalMessage);
    }

    private static Map<Integer, List<Integer>> getAllDividers(int num, int[] divisionNums) {
        int currentDivider;
        List<Integer> dividers = new ArrayList<>();
        Map<Integer, List<Integer>> allDividers = new HashMap<>();
        boolean dividerIsFound = true;
        for (Integer value : divisionNums) {
            if (num % value == 0) {
                currentDivider = value;
                dividers.add(currentDivider);
                allDividers.put(value, dividers);
            }
        }
        if (!dividerIsFound) {
            System.out.println("Not divisible");
        }

        getBiggestDivider(allDividers);

        return allDividers;
    }

    private static int getBiggestDivider(Map<Integer, List<Integer>> allDividers) {
        int maxDivider = Integer.MIN_VALUE;
        //StringBuilder pair = new StringBuilder();
        int maxKey = 0;
        for (Map.Entry<Integer, List<Integer>> map : allDividers.entrySet()) {
            List<Integer> values = map.getValue();
            int key = map.getKey();
            for (Integer num : values) {
                if (num > maxDivider) {
                    maxDivider = num;
                    maxKey = key;
                }
            }
        }

        //  pair.append(maxKey).append(":").append(maxDivider);
        return maxDivider;
    }
}
