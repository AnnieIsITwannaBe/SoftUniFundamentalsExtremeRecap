package ListsLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            String output = " ";

            switch (command) {
                case "Contains":
                    int numberTarget = Integer.parseInt(tokens[1]);
                    handleContainsLogic(nums, numberTarget);
                    break;
                case "Print":
                    String numType = tokens[1];
                    output = handlePrintLogic(numType, nums);
                    printValue(output);

                    break;
                case "Get":
                    int sum = handleGetSumLogic(nums);
                    printValue(sum);

                    break;
                case "Filter":
                    String condition = tokens[1];
                    int num = Integer.parseInt(tokens[2]);
                    output = handleFilterLogic(condition, num, nums);
                    printValue(output);
                    break;
            }

            input = scanner.nextLine();
        }
    }

    private static String handleFilterLogic(String condition, int numTarget, List<Integer> nums) {
        List<Integer> filetred = new ArrayList<>();

        filetred = switch (condition) {
            case "<" -> findNumbersSmallerThanTargetNum(numTarget, nums);
            case ">" -> findNumbersBiggerThanTargetNum(numTarget, nums);
            case ">=" -> findNumbersBiggerOrEqualToTargetNum(numTarget, nums);
            case "<=" -> findNumberSmallerOrEqualToTargetNum(numTarget, nums);
            default -> filetred;
        };

        StringBuilder sb = new StringBuilder();
        sb.append(listToString(filetred));

        return sb.toString();
    }

    private static List<Integer> findNumberSmallerOrEqualToTargetNum(int numTarget, List<Integer> nums) {
        List<Integer> list = new ArrayList<>();
        for (Integer num : nums) {
            if (num <= numTarget) {
                list.add(num);
            }
        }
        return list;
    }

    private static List<Integer> findNumbersBiggerOrEqualToTargetNum(int numTarget, List<Integer> nums) {
        List<Integer> list = new ArrayList<>();
        for (Integer num : nums) {
            if (num >= numTarget) {
                list.add(num);
            }
        }
        return list;
    }

    private static List<Integer> findNumbersBiggerThanTargetNum(int numTarget, List<Integer> nums) {

        List<Integer> list = new ArrayList<>();
        for (Integer num : nums) {
            if (num > numTarget) {
                list.add(num);
            }
        }
        return list;
    }

    private static List<Integer> findNumbersSmallerThanTargetNum(int numTarget, List<Integer> nums) {
        List<Integer> list = new ArrayList<>();
        for (Integer num : nums) {
            if (num < numTarget) {
                list.add(num);
            }
        }
        return list;
    }

    private static int handleGetSumLogic(List<Integer> nums) {
        return nums.stream().mapToInt(Integer::intValue).sum();
    }


    public static <T> void printValue(T value) {
        System.out.println(value);
    }


    private static String handlePrintLogic(String numType, List<Integer> nums) {
        List<Integer> even = new ArrayList<>();
        List<Integer> odd = new ArrayList<>();

        populateLists(nums, even, odd);

        StringBuilder sb = new StringBuilder();
        if (numType.equals("even")) {
            sb.append(listToString(even));
        } else {
            sb.append(listToString(odd));
        }

        return sb.toString();

    }

    private static void populateLists(List<Integer> nums, List<Integer> even, List<Integer> odd) {
        for (Integer num : nums) {
            if (num % 2 == 0) {
                even.add(num);
            } else {
                odd.add(num);
            }

        }
    }

    private static String listToString(List<Integer> nums) {
        StringBuilder sb = new StringBuilder();
        for (Integer num : nums) {
            sb.append(num).append(" ");
        }

        return sb.toString();
    }

    private static void handleContainsLogic(List<Integer> nums, int numberTarget) {
        if (nums.contains(numberTarget)) {
            System.out.println("Yes");
        } else {
            System.out.println("No such number");
        }
    }
}
