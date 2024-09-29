package ExamPreparation.RandomizedJudge.MidExamRetake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar {
    private static final String SUNKEN_SHIP_SUCCESSFULLY = "You won! The enemy ship has sunken.";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> pirateShipState = Arrays.stream(scanner.nextLine().split(">")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
        int maximumHealthCapacity = Integer.parseInt(scanner.nextLine());

        String line = scanner.nextLine();
        while (!line.equals("Retire")) {
            String[] tokens = line.split("\\s+");

            String command = tokens[0];
            switch (command) {
                case "Fire":
                    if (shipIsSunken(tokens, pirateShipState)) return; // exits the current method
                    break;

                case "Defend":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    int damage = Integer.parseInt(tokens[3]);


                    break;

                case "Repair":
                    break;

                case "Status":
                    break;


            }

            line = scanner.nextLine();
        }
    }

    private static boolean shipIsSunken(String[] tokens, List<Integer> pirateShipState) {
        int index = Integer.parseInt(tokens[1]);
        int damage = Integer.parseInt(tokens[2]);

        if (isValid(index, pirateShipState)) {
            int selectedSectionHealth = pirateShipState.get(index);
            selectedSectionHealth -= damage;
            pirateShipState.set(index, selectedSectionHealth);

            if (selectedSectionHealth <= 0) {
                System.out.println(SUNKEN_SHIP_SUCCESSFULLY);

                return true;
            }
        }
        return false;
    }

    private static boolean isValid(int index, List<Integer> pirateShipState) {
        return index > 0 && index < pirateShipState.size() - 1;
    }
}
////here we need to end the entire program after we have sunken the enemy ship:
//                            //This is because return will exit the current method, effectively ending the loop and any further processing in that method.
//                            //i have left some notes for you to read on the subject down below
//                            //little me taking care of me so cute
//Here's a brief explanation of why return works here:
//
//return: This keyword will exit from the current method. In the context of your while loop, if you use return inside the loop, it will break out of the loop and also exit the method that contains this loop. This is appropriate when you want to stop all further processing and terminate the method.
//Here's a more detailed explanation of the break, continue, and return keywords in the context of loops:
//
//break: Exits the loop, but continues executing the code after the loop. This is useful if you want to stop looping but still continue executing further code after the loop.
//
//continue: Skips the rest of the current iteration of the loop and proceeds with the next iteration. It does not exit the loop but just moves to the next iteration.
//
//return: Exits from the current method, which means it will also exit from the loop within that method. This stops the method's execution entirely.
//
//In your case, to exit the entire program when the ship is sunk, you should use return in the switch-case block. Here is how you should modify your code: