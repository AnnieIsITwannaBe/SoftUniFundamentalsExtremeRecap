package ListsLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");

            String command = tokens[0];
            switch (command) {
                case "Add":
                    int numberToBeAdded = Integer.parseInt(tokens[1]);
                    nums.add(numberToBeAdded);

                    break;
                case "Remove":
                    int numberToBeRemoved = Integer.parseInt(tokens[1]);
                    nums.remove(numberToBeRemoved);

                    break;
                case "RemoveAt":
                    int indexToBeRemoved = Integer.parseInt(tokens[1]);
                    nums.remove(indexToBeRemoved);

                    break;
                case "Inset":
                    int numberToBeInserted = Integer.parseInt(tokens[1]);
                    int indexToBeFilled = Integer.parseInt(tokens[2]);
                    nums.add(indexToBeFilled, numberToBeInserted);

                    break;
            }

            input = scanner.nextLine();
        }

        printFormat(nums);
    }

    private static void printFormat(List<Integer> nums) {
        for (Integer num : nums) {
            System.out.print(num + " ");
        }
    }
}
