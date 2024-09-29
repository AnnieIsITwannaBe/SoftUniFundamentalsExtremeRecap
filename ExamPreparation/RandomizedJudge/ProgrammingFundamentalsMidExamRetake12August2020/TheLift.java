package ExamPreparation.RandomizedJudge.ProgrammingFundamentalsMidExamRetake12August2020;

import java.util.Arrays;
import java.util.Scanner;

public class TheLift {
    public static final String NOT_ENOUGH_SPACE = "There isn't enough space! %d people in a queue!";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalAmount = Integer.parseInt(scanner.nextLine());
        int[] trainWagons = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int trainWagonsTotalCount = trainWagons.length;

        for (int trainWagon : trainWagons) {
            int trainCurrentWagonState = trainWagon;

            while (trainCurrentWagonState != 4) {
                totalAmount--;
                trainCurrentWagonState++;

                if (totalAmount == 0) {
                    if (trainCurrentWagonState < 4) {
                        System.out.println("there are empty spaces");
                        break;
                    }
                }
            }
        }

        if (totalAmount > 0) {
            System.out.printf(NOT_ENOUGH_SPACE, totalAmount);
        }

    }
}
//Issues and Improvements
//Correctness of the Logic:
//
//The current logic iterates over the train wagons but does not properly modify the wagons' states in the array. The variable trainCurrentWagonState is used to track the current state of a wagon, but this does not update the actual array trainWagons. As a result, the final states of the wagons are not accurately reflected.
//Termination Condition:
//
//The loop decreases totalAmount until it reaches 0, but it does not break out of the outer loop (for loop over trainWagons). If totalAmount becomes 0, the loop should break to avoid further unnecessary iterations.
//Handling Remaining Passengers:
//
//You correctly handle the case where there are remaining passengers after all wagons are filled. However, there's a missing scenario where the lift might be completely filled with no empty spaces but some passengers might still remain.
//Empty Spaces Handling:
//
//The output message "there are empty spaces" is printed when there are no more passengers but some wagons are not fully filled. However, the message doesn't account for partially filled wagons and the final state of the lift.
//Input and Output Formatting:
//
//Ensure that the final state of the lift is printed as required by the problem statement, especially after filling the wagons.