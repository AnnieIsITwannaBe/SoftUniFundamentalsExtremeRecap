package ExamPreparation.RandomizedJudge.MidExamRetakeApril2020;

import java.util.Arrays;
import java.util.Scanner;

//Write a program that helps you keep track of your shot targets. You will receive a sequence with integers,
// separated by a single space, representing targets and their value. Afterward, you will be receiving
// indices until the "End" command is given, and you need to print the targets and the count of shot targets.
//Every time you receive an index, you need to shoot the target on that index, if it is possible.
//Every time you shoot a target, its value becomes -1, and it is considered a shot. Along with that, you also need to:
//•	Reduce all the other targets, which have greater values than your current target, with its value.
//•	Increase all the other targets, which have less than or equal value to the shot target, with its value.
//Keep in mind that you can't shoot a target, which is already shot. You also can't increase or reduce a target, which is considered a shot.
//When you receive the "End" command, print the targets in their current state and the count of shot targets in the following format:
//"Shot targets: {count} -> {target1} {target2}… {targetn}"

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] targets = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String line = scanner.nextLine();
        int shotTargetCount = 0;
        handleShootingProcess(line, targets, shotTargetCount, scanner);


        System.out.printf("Shot targets: %d", shotTargetCount);
        for (int target : targets) {
            System.out.printf("%d ", target);
        }

    }

    private static void handleShootingProcess(String line, int[] targets, int shotTargetCount, Scanner scanner) {
        while (!line.equals("End")) {
            int targetIndex = Integer.parseInt(line);

            if (isValid(targetIndex, targets)) {
                if (isPossibleToShoot(targetIndex, targets)) {
                    int currentValueOfTarget = targets[targetIndex];
                    targets[targetIndex] = -1;
                    shotTargetCount++;

                    for (int i = 0; i < targets.length; i++) {
                        if (targets[i] > currentValueOfTarget) {
                            targets[i] -= currentValueOfTarget;
                        }
                    }
                }
            }
            line = scanner.nextLine();
        }
    }

    private static boolean isPossibleToShoot(int targetIndex, int[] targets) {
        return targets[targetIndex] != -1;
    }

    //check whether is in bounds
    private static boolean isValid(int targetIndex, int[] targets) {
        return targetIndex > 0 && targetIndex < targets.length;
    }
}
