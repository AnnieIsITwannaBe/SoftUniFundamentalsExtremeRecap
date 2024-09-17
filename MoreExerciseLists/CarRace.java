package MoreExerciseLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CarRace {
    private static final String WINNER_MESSAGE = "The winner is %s with total time: %.1f";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //starts from the left side
        List<Integer> first = collectUserInput(scanner);
        //starts from the right side
        List<Integer> second = collectUserInput(scanner);

        //the finish line is middle of the list: the number of the elements will always be odd
        //each element represents the time to get trough that step

        int middleIndexFirst = defineFinishLineIndex(first);
        double firstTimeNeeded = timeToGetToFinishLineLeftStart(first, middleIndexFirst);

        int middleIndexSecond = defineFinishLineIndex(second);
        double secondTimeNeeded = timeToGetToFinishLineRightStart(second, middleIndexSecond);

        if (firstTimeNeeded < secondTimeNeeded) {
            System.out.printf(WINNER_MESSAGE, "first", firstTimeNeeded);
        } else {
            System.out.printf(WINNER_MESSAGE, "second", secondTimeNeeded);
        }

    }

    private static double timeToGetToFinishLineRightStart(List<Integer> second, int middleIndexSecond) {
        double time = 0;

        for (int i = second.indexOf(middleIndexSecond); i >= 0; i--) {
            time += second.get(i);
        }

        return time;
    }

    private static double timeToGetToFinishLineLeftStart(List<Integer> first, int middleIndexFirst) {
        //time is equal to the element's value before they get to the finish line:
        //does the middle count? is it inclusive
        double time = 0.0;


        for (int i = 0; i <= first.indexOf(middleIndexFirst); i++) {
            time += first.get(first.get(i));
        }

        return time;
    }
    // so even when not explicitly defined in the scope of the for loop it still can be iterated upon, fascinating

    private static int defineFinishLineIndex(List<Integer> first) {
        int n = first.size();

        int result = n / 2;
        if (n % 2 == 0) {
            return result - 1;
        }
        return result;
    }
    //even and odd number of elements


    private static ArrayList<Integer> collectUserInput(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));
    }
}
