package ExamPreparation.RandomizedJudge.MidExamRetakeApril2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MovingTarget {
    public static final String STRIKE_MISSED_MESSAGE = "Strike missed!";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //  int[] targets = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        List<Integer> targets = new ArrayList<>(Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toList());

        String line = scanner.nextLine();
        while (!line.equals("end")) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Shoot":
                    handleShoot(tokens, targets);

                    break;
                case "Add":
                    handleAdd(tokens, targets);

                    break;
                case "Strike":
                    int index = Integer.parseInt(tokens[1]);
                    int radius = Integer.parseInt(tokens[2]);


                    if (ItExist(index, targets)) {
                        int start = index + radius;
                        int end = index - radius;

                        for (int i = end; i >= start; i--) {
                            if (start > 0 && end < targets.size()) {
                                targets.remove(i);
                            } else {
                                System.out.println(STRIKE_MISSED_MESSAGE);

                            }

                        }
                    }else {
                        System.out.println(STRIKE_MISSED_MESSAGE);
                    }

                    break;
            }
            line = scanner.nextLine();
        }
    }

    private static boolean rangeIsValid(List<Integer> beforeTarget, int radius, List<Integer> afterTarget) {
        return beforeTarget.size() >= radius && afterTarget.size() >= radius;
    }

    private static void handleAdd(String[] tokens, List<Integer> targets) {
        int index = Integer.parseInt(tokens[1]);
        int value = Integer.parseInt(tokens[2]);

        if (ItExist(index, targets)) {
            targets.add(index, value);
        } else {
            System.out.println("Invalid placement!");
        }
    }

    private static void handleShoot(String[] tokens, List<Integer> targets) {
        int index = Integer.parseInt(tokens[1]);
        int value = Integer.parseInt(tokens[2]);

        //importante:
        //The issue you're encountering is due to how Java handles assignment to elements in a list. The line targets.get(index) = result; is not valid because get(index) returns a value, not a reference that you can assign a new value to.
        //
        //In Java, get(index) retrieves the value at a specified index in a list, but you can't use it directly to assign a new value. Instead, you need to use the set(index, value) method to update the value at a particular index in the list.
        //
        //Here's how you can modify your code:

        if (ItExist(index, targets)) {
            int result = targets.get(index) - value;
            targets.set(index, result);
        }

        if (isShot(targets, index)) {
            targets.remove(index);
        }
    }

    private static boolean isShot(List<Integer> targets, int index) {
        return targets.get(index) == 0;
    }

    private static boolean ItExist(int index, List<Integer> targets) {
        return index > 0 && index <= targets.size();
    }
}
//Yes, you're absolutely right! The reason for removing elements from the end of the range towards the start is to avoid issues with shifting indices during the removal process.
//
//### Detailed Explanation:
//- **Removing from the End**:
//   - When you remove an element from a list in Java, all the elements that come after the removed element shift left by one position (their indices decrease by 1).
//   - If you start removing from the beginning of your range (`start` to `end`), the index positions of the remaining elements will change after each removal. This shifting would cause you to accidentally skip over elements or try to access an index that no longer exists.
//
//- **Removing from the Start**:
//   - For example, if you remove the element at `index = 2`, the element that was at `index = 3` will move to `index = 2`. If your next operation is to remove `index = 3`, you would actually remove what was originally at `index = 4`, and so on.
//
//### Example Scenario:
//Let's assume we have a list of `[10, 20, 30, 40, 50]` and we want to remove elements from index 1 to 3.
//
//#### If Removing from Start to End:
//- Remove element at index `1`: List becomes `[10, 30, 40, 50]`.
//- Remove element at index `2`: List becomes `[10, 30, 50]` (notice `40` was skipped because `30` moved to index 1).
//
//#### If Removing from End to Start:
//- Remove element at index `3`: List becomes `[10, 20, 30, 50]`.
//- Remove element at index `2`: List becomes `[10, 20, 50]`.
//- Remove element at index `1`: List becomes `[10, 50]`.
//
//This way, all elements intended for removal are correctly removed without skipping any or causing index errors.