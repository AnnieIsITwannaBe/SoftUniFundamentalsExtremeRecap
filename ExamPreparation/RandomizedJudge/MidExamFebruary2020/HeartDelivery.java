package ExamPreparation.RandomizedJudge.MidExamFebruary2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> currentHeartStates = Arrays.stream(scanner.nextLine().split("@")).
                map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));


        int currentIndex = 0;
        String line = scanner.nextLine();
        while (!line.equals("Love!")) {
            String[] tokens = line.split("\\s+");
            int distanceToJump = Integer.parseInt(tokens[1]);

            // list.size 5 and distance == 6; 5-6 = 1 //мне така не работи защото като ни стане тоя случай ще скипне нулевия индекс

            int overallDistance = currentIndex + distanceToJump;

            if (isValid(overallDistance, currentHeartStates)) {
                updateHeartQuantityAccordingly(currentHeartStates, overallDistance);
            } else {
                int loopedIndex = currentHeartStates.size() - overallDistance;
                updateHeartQuantityAccordingly(currentHeartStates, loopedIndex);

            }


            line = scanner.nextLine();
        }
    }

    private static void updateHeartQuantityAccordingly(List<Integer> currentHeartStates, int overallDistance) {
        int currentHouseHeartQuantity = currentHeartStates.get(overallDistance);
        currentHouseHeartQuantity -= 2;
        currentHeartStates.set(overallDistance, currentHouseHeartQuantity);
    }

    private static boolean isValid(int overallDistance, List<Integer> list) {
        return overallDistance < list.size();
    }
}
//what to focus on:
//The reason why the operation currentHeartStates.get(overallDistance) -= 2 isn't possible when working with lists in Java is because the get() method of the List interface returns a value (in this case, an Integer) that is immutable. Java's Integer is a wrapper class for the primitive int, and it behaves as an immutable object. You can't directly modify the value inside the list using this approach.
//
//In Java, when you use the get() method of a list, it returns a reference to an object, but you cannot change the value in place like you would with an array or primitive.
//
//Solution:
//To modify the value in the list, you need to retrieve the current value, perform the arithmetic operation, and then update the list using the set() method.
//
//Here’s how you can do it:
