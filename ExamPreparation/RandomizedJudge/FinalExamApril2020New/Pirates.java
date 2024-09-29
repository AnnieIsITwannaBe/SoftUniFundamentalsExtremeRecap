package ExamPreparation.RandomizedJudge.FinalExamApril2020New;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.spi.AbstractResourceBundleProvider;
//МНОГОСТРАДАЛНА ГЕНОВЕВА


public class Pirates {
    private static final String TOWN_PLUNDERED_MESSAGE = "%s plundered! %d gold stolen, %d citizens killed.";

    private static final String TOWN_DISBANDED = "%s has been wiped off the map!";

    private static final String GOLD_CANNOT_BE_A_NEGATIVE_NUMBER = "Gold added cannot be a negative number!";

    private static final String GOLD_ADDED_TO_CITY_TREASURY = "%d gold added to the city treasury. %s now has %d gold.";

    private static final String CAPTAIN_PLUNDERED_ALL = "Ahoy, Captain! All targets have been plundered and destroyed!";

    private static final String FINAL_MESSAGE = "%s -> Population: %d citizens, Gold: %d kg\n";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userInput = scanner.nextLine();

        List<Town> townList = addTownToList(userInput, scanner);

        userInput = scanner.nextLine();

        handleVoyage(userInput, townList, scanner);

        handleFinalMessage(townList);

    }

    private static void handleVoyage(String line, List<Town> townList, Scanner scanner) {
        while (line.equals("End")) {
            String[] tokens = line.split("\\s+=>\\s+");
            String command = tokens[0];

            switch (command) {
                case "Plunder":
                    handlePlunder(tokens, townList);
                    break;

                case "Prosper":
                    handleProsper(tokens, townList);
                    break;
            }
            line = scanner.nextLine();
        }
    }

    private static void handleFinalMessage(List<Town> townList) {
        if (townList.isEmpty()) {
            System.out.println(CAPTAIN_PLUNDERED_ALL);
        } else {
            townList.forEach(town -> System.out.printf(FINAL_MESSAGE, town.getTown(), town.getPopulation(), town.getGold()));
        }
    }

    private static void handleProsper(String[] tokens, List<Town> townList) {
        String town = tokens[1];
        int gold = Integer.parseInt(tokens[2]);

        if (isNegative(gold)) {
            System.out.println(GOLD_CANNOT_BE_A_NEGATIVE_NUMBER);
        } else {
            Town selectedTown = getSelectedTown(townList, town);
            assert selectedTown != null;

            selectedTown.setGold(selectedTown.getGold() + gold);
            System.out.printf(GOLD_ADDED_TO_CITY_TREASURY, gold, town, selectedTown.getGold());
        }
    }

    private static boolean isNegative(int gold) {
        return gold < 0;
    }

    private static void handlePlunder(String[] tokens, List<Town> townList) {
        String attackedTown = tokens[1];
        int populationKilled = Integer.parseInt(tokens[2]);
        int goldStolen = Integer.parseInt(tokens[3]);

        Town selectedTown = getSelectedTown(townList, attackedTown);

        assert selectedTown != null;
        selectedTown.setPopulation(selectedTown.getPopulation() - populationKilled);
        selectedTown.setGold(selectedTown.getGold() - goldStolen);

        if (selectedTown.getPopulation() <= 0 || selectedTown.getGold() <= 0) {
            System.out.printf(TOWN_DISBANDED, attackedTown);
            townList.remove(selectedTown);
        } else {
            System.out.printf(TOWN_PLUNDERED_MESSAGE, attackedTown, goldStolen, populationKilled);
        }
    }

    private static Town getSelectedTown(List<Town> townList, String attackedTown) {
        return townList.stream().
                filter(currentTown -> currentTown.getTown().equals(attackedTown))
                .findFirst().orElse(null);
    }

    private static List<Town> addTownToList(String line, Scanner scanner) {
        List<Town> townList = new LinkedList<>();
        while (!line.equals("Sail")) {
            String[] tokens = line.split("\\||");
            String town = tokens[0];
            int population = Integer.parseInt(tokens[1]);
            int gold = Integer.parseInt(tokens[2]);

            Town currentTown = new Town(town, population, gold);
            townList.add(currentTown);

            line = scanner.nextLine();
        }
        return townList;
    }
}
