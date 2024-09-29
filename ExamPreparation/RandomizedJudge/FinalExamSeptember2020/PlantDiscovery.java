package ExamPreparation.RandomizedJudge.FinalExamSeptember2020;

import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPlants = Integer.parseInt(scanner.nextLine());

        List<Plant> plants = addPlantsToInventory(numberOfPlants, scanner);

        Map<Plant, List<Integer>> plantsRatings = processUserInput(scanner, plants);


        //there most probably should be a way in which this looks better and still works
        Map<Plant, Double> plantAverageRating = extractAverageRatings(plantsRatings);

        //handle output:
        System.out.println("Plants for the exhibition:");
        plantAverageRating.forEach((key, value) -> System.out.printf("%s %d %.2f",
                key.getPlant(), key.getRarity(), value));
    }

    private static Map<Plant, Double> extractAverageRatings(Map<Plant, List<Integer>> plantsRatings) {
        Map<Plant, Double> plantAverageRating = new LinkedHashMap<>();
        for (Map.Entry<Plant, List<Integer>> entry : plantsRatings.entrySet()) {
            List<Integer> currentPlantRatings = entry.getValue();
            double average = getAverage(currentPlantRatings);
            Plant currentPlant = entry.getKey();
            plantAverageRating.put(currentPlant, average);
        }
        return plantAverageRating;
    }

    private static double getAverage(List<Integer> currentPlantRatings) {
        double sum = 0.0;
        for (Integer currentPlantRating : currentPlantRatings) {
            sum += currentPlantRating;
        }

        return sum / currentPlantRatings.size();
    }

    private static Map<Plant, List<Integer>> processUserInput(Scanner scanner, List<Plant> plants) {
        Map<Plant, List<Integer>> plantsRatings = new LinkedHashMap<>();
        String line = scanner.nextLine();
        while (!line.equals("Exhibition")) {
            String[] tokens = line.split(":");
            String command = tokens[0];
            switch (command) {
                case "Rate":
                    handleRating(tokens, plants, plantsRatings);

                    break;
                case "Update":
                    handleUpdate(tokens, plants);

                    break;
                case "Reset":
                    handleReset(tokens, plants, plantsRatings);
                    break;
            }
            line = scanner.nextLine();
        }
        return plantsRatings;
    }

    private static void handleReset(String[] tokens, List<Plant> plants, Map<Plant, List<Integer>> plantsRatings) {
        String[] stats = getSplit(tokens);
        String plant = stats[0];

        Plant selectedPlant = getSelectedPlant(plants, plant);
        assert selectedPlant != null;

        boolean isPresentInDataBase = plantsRatings.containsKey(selectedPlant);

        if (isPresentInDataBase) {
            List<Integer> ratingReset = plantsRatings.get(selectedPlant);
            ratingReset.clear();
            plantsRatings.put(selectedPlant, ratingReset);
        }
    }

    private static String[] getSplit(String[] tokens) {
        return tokens[1].split("\\s+-\\s+");
    }

    private static void handleUpdate(String[] tokens, List<Plant> plants) {
        String[] stats = tokens[1].split("\\s+-\\s+");
        String plant = stats[0];
        int rarity = Integer.parseInt(stats[1]);

        //what does asset do exactly?
        //виж го тва като се качиш и как да print-неш error ако не става
        Plant selectedPlant = getSelectedPlant(plants, plant);
        assert selectedPlant != null;
        System.out.println("Error");

        selectedPlant.setRarity(rarity);
    }

    private static void handleRating(String[] tokens, List<Plant> plants, Map<Plant, List<Integer>> plantsRatings) {
        String[] stats = tokens[1].split("\\s+-\\s+");
        String plant = stats[0];
        int rating = Integer.parseInt(stats[1]);

        Plant selectedPlant = getSelectedPlant(plants, plant);
        assert selectedPlant != null;

        plantsRatings.putIfAbsent(selectedPlant, new ArrayList<>());
        List<Integer> updatedRatings = plantsRatings.get(selectedPlant);
        updatedRatings.add(rating);
        plantsRatings.put(selectedPlant, updatedRatings);
    }

    private static Plant getSelectedPlant(List<Plant> plants, String plant) {
        return plants.stream().filter(plantTarget -> plantTarget.getPlant()
                .equals(plant)).findFirst().orElse(null);
    }

    private static List<Plant> addPlantsToInventory(int numberOfPlants, Scanner scanner) {
        List<Plant> plants = new LinkedList<>();
        for (int i = 0; i < numberOfPlants; i++) {
            String[] tokens = scanner.nextLine().split("<->");
            String plant = tokens[0];
            int rarity = Integer.parseInt(tokens[1]);

            Plant currentPlant = new Plant(plant, rarity);
            //ensure uniqueness of plants:
            if (!plants.contains(currentPlant)) {
                plants.add(currentPlant);
            }
        }
        return plants;
    }
}
