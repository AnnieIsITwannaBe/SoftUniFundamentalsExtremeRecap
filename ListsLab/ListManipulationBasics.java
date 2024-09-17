package ListsLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];
            int value = Integer.parseInt(tokens[1]);

            int index = 0;

            switch (command) {
                case "Add":
                    nums.add(value);
                    break;
                case "Remove":
                    nums.remove((Integer) value);
                    break;
                case "RemoveAt":
                    index = Integer.parseInt(tokens[1]);
                    nums.remove(index);

                    break;
                case "Insert":
                    int secondValue = Integer.parseInt(tokens[2]);
                    index = Integer.parseInt(tokens[1]);
                    nums.add(index, secondValue);


                    break;
            }

            input = scanner.nextLine();
        }
    }
}
