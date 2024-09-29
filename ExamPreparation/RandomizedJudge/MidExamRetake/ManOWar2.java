package ExamPreparation.RandomizedJudge.MidExamRetake;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ManOWar2 {
    //that needs to be edited and given some thought:
    private static final String BREAK_LOOP_WORD = "Retire";

    private static final String SUNKEN_ENEMY_SHIP_SUCCESSFULLY = "You won! The enemy ship has sunken.";

    private static final String PIRATE_SHIP_SUNKEN_GAME_LOST = "You lost! The pirate ship has sunken.";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> pirateShip = collectUserData(scanner);

        List<Integer> warShip = collectUserData(scanner);

        int maximumHealthCapacityPerSection = Integer.parseInt(scanner.nextLine());

        String line = scanner.nextLine();
        while (!line.equals(BREAK_LOOP_WORD)) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "Fire":
                    if (enemyShipHasSunken(tokens, warShip)) return;
                    break;

                case "Defend":
                    if (pirateShipHasSunken(tokens, pirateShip)) return;
                    break;

                case "Repair":
                    if (handleRepair(tokens, pirateShip, maximumHealthCapacityPerSection)) continue;

                    break;
                case "Status":
                    handleStatusDisplay(maximumHealthCapacityPerSection, pirateShip);
                    break;
            }
            line = scanner.nextLine();
        }

    }

    private static void handleStatusDisplay(int maximumHealthCapacityPerSection, List<Integer> pirateShip) {
        //o elaborate, if you want to determine what 20 percent of the maximumHealthCapacityPerSection is,
        // you simply multiply the maximum health capacity by 0.2. Here’s how the code works:
        double twentyPercentOfMaximumHealthCapacity = maximumHealthCapacityPerSection * 0.2;

        //You’re right—if currentHealth is not a percentage but an absolute value representing the current health of a section,
        // you need to convert this to a percentage of the maximum health capacity in order to compare it properly.

        int shipsTobeRepaired = 0;
        for (int currentSection : pirateShip) {
            double currentStateHealthPercent = (double) currentSection / maximumHealthCapacityPerSection * 100;
            if (currentStateHealthPercent < twentyPercentOfMaximumHealthCapacity) {
                shipsTobeRepaired++;
            }
        }

        System.out.println(shipsTobeRepaired);
    }

    private static boolean handleRepair(String[] tokens, List<Integer> pirateShip, int maximumHealthCapacityPerSection) {
        int index = Integer.parseInt(tokens[1]);
        int health = Integer.parseInt(tokens[2]);

        if (isValid(index, pirateShip)) {
            int pirateShipCurrentState = pirateShip.get(index);
            pirateShipCurrentState += health;
            if (pirateShipCurrentState > maximumHealthCapacityPerSection) {
                pirateShip.set(index, maximumHealthCapacityPerSection);
            } else {
                pirateShip.set(index, pirateShipCurrentState);
            }

        } else {
            return true;
        }
        return false;
    }

    private static boolean pirateShipHasSunken(String[] tokens, List<Integer> pirateShip) {
        int startIndex = Integer.parseInt(tokens[1]);
        int endIndex = Integer.parseInt(tokens[2]);
        int damage = Integer.parseInt(tokens[3]);

        if (isValid(startIndex, pirateShip) && isValid(endIndex, pirateShip)) {
            for (int i = startIndex; i < endIndex; i++) {
                int currentPirateShipSection = pirateShip.get(i);
                currentPirateShipSection -= damage;
                pirateShip.set(i, currentPirateShipSection);
                if (currentPirateShipSection <= 0) {
                    System.out.printf(PIRATE_SHIP_SUNKEN_GAME_LOST);
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean enemyShipHasSunken(String[] tokens, List<Integer> currentShip) {
        int index = Integer.parseInt(tokens[1]);
        int damage = Integer.parseInt(tokens[2]);

        if (isValid(index, currentShip)) {
            int currentWarShipSectionState = currentShip.get(index);
            currentWarShipSectionState -= damage;
            currentShip.set(index, currentWarShipSectionState);
            if (currentWarShipSectionState <= 0) {
                System.out.printf(SUNKEN_ENEMY_SHIP_SUCCESSFULLY);
                return true;
            }
        }
        return false;
    }

    private static boolean isValid(int index, List<Integer> warShip) {
        return index > 0 && index < warShip.size() - 1;
    }

    private static ArrayList<Integer> collectUserData(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(">")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
