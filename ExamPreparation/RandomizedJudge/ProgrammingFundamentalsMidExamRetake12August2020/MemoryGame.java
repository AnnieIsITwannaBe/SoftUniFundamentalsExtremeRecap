package ExamPreparation.RandomizedJudge.ProgrammingFundamentalsMidExamRetake12August2020;

import java.util.*;
import java.util.stream.Collectors;

public class MemoryGame {
    public static final String INVALID_INPUT = "Invalid input! Adding additional elements to the board";

    public static final String MATCHING_PAIR_CONGRATS_MESSAGE = "Congrats! You have found matching elements - %s!";

    public static final String NOT_MATCHING = "Try again!";

    public static final String LITTLE_OVERACHIEVER_WON_BEFORE_TIMEOUT = "You have won in %d turns!";

    public static final String BRO_LOST_THE_GAME = "Sorry you lose : (\n%d";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> sequenceOfElements = new ArrayList<>(Arrays.stream(scanner.nextLine().split("\\s+")).toList());

        boolean sequenceExtinguished = sequenceOfElements.isEmpty();

        String line = scanner.nextLine();
        int numberOfMoves = 0;
        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");
            int numericValueA = Integer.parseInt(tokens[0]);
            int numericValueB = Integer.parseInt(tokens[1]);
            numberOfMoves++;

            //if player cheats:
            boolean isValid = numericValueA != numericValueB && numericValueA < sequenceOfElements.size() && numericValueB < sequenceOfElements.size();
            if (isValid) {
                handleCheatingPenalties(sequenceOfElements, numberOfMoves);

            } else {
                for (int i = 0; i < sequenceOfElements.size(); i++) {
                    if (sequenceOfElements.get(numericValueA).equals(sequenceOfElements.get(numericValueB))) {
                        System.out.printf(MATCHING_PAIR_CONGRATS_MESSAGE, sequenceOfElements.get(numericValueA));
                        sequenceOfElements.remove(numericValueA);
                        sequenceOfElements.remove(numericValueB);
                    } else {
                        System.out.println(NOT_MATCHING);
                    }
                }

                //we want to break the while loop, not the for-loop here
                //i'm interested will a problem emerge from the fact that we're removing elements
                //from a collection while iterating over it at the same time?
                if (sequenceExtinguished) {
                    System.out.printf(LITTLE_OVERACHIEVER_WON_BEFORE_TIMEOUT, numberOfMoves);
                    break;
                }
            }
            line = scanner.nextLine();
        }

        if (!sequenceExtinguished) {
            System.out.printf(BRO_LOST_THE_GAME, sequenceOfElements.size());
        }
    }
    private static void handleCheatingPenalties(List<String> sequenceOfElements, int numberOfMoves) {
        int middleIndex = sequenceOfElements.size() / 2;

        //because from what i gather in the input they have to be on separate indexes:
        sequenceOfElements.add(middleIndex, String.valueOf(numberOfMoves));
        sequenceOfElements.add(middleIndex + 1, String.valueOf('a'));
        System.out.println(INVALID_INPUT);
    }
}
//какво е reverse enguineering?
//братле, има .sublist, тва не е ли хипер яко?
////problem to solve
//                //find the middle part of a collection;

//Your implementation of the "Memory Game" is quite good and addresses many of the core requirements. However, there are some issues and areas for improvement to ensure the game works correctly and efficiently. I'll go over the main points:
//
//Issues and Improvements
//Cheat Handling (handleCheatingPenalties method):
//
//Your code correctly handles invalid inputs where the user might cheat by using the same index twice or providing out-of-bound indices. However, the method handleCheatingPenalties does not effectively manage the insertion of the penalty elements.
//The penalty elements should be added as "-{number of moves}a" at the middle of the sequence, but your current code adds the move number and the character 'a' separately. This can be simplified by inserting a single formatted string.
//Sequence Extinguished Check:
//
//The condition sequenceExtinguished = sequenceOfElements.isEmpty(); is evaluated only once before the loop starts, so it will not reflect changes made to sequenceOfElements during the game.
//You should update sequenceExtinguished after each successful pair removal.
//Removing Elements During Iteration:
//
//You're removing elements from the list within the iteration block. This is risky because it can cause IndexOutOfBoundsException if not handled carefully.
//To avoid this, either collect the indices to be removed first and then remove them after the iteration, or make sure to always remove the element with the higher index first.
//Output Messages and Logic Flow:
//
//The message "Congrats! You have found matching elements" is printed correctly. However, after removing elements, you need to check immediately if the sequence is extinguished (i.e., if the player has won) and break the loop accordingly.
//The "Sorry you lose :(" message and the sequence state should be printed only if the game ends without the player clearing all elements.
//Revised Code
//Here’s an updated version of your code with the suggested improvement