package ExamPreparation.RandomizedJudge.MidExamRetake;

import java.util.*;
import java.util.stream.Collectors;

public class TreasureHunt {
    private static final String AVERAGE_TREASURE_GAIN = "Average treasure gain: %.2f pirate credits";

    private static final String TREASURE_HUNTING_FAILED = "Failed treasure hunt.";

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<String> treasureChest = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toCollection(ArrayList::new));

        String line = scanner.nextLine();
        while (!line.equals("Yohoho!")) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Loot":
                    handleLoot(tokens, treasureChest);

                    break;
                case "Drop":
                    handleDrop(tokens, treasureChest);
                    break;

                case "Steal":
                    handleSteal(tokens, treasureChest);
                    break;

            }
            line = scanner.nextLine();
        }

        // OptionalDouble averageTreasureGain = treasureChest.stream().mapToDouble(String::length).average();
        //this is cool to know but not what they're requiring from us in the problem description

//        if (averageTreasureGain.isPresent()) {
//            System.out.printf(AVERAGE_TREASURE_GAIN, averageTreasureGain.orElseThrow(Exception::new));
//        }


        if (treasureChest.isEmpty()) {
            System.out.println(TREASURE_HUNTING_FAILED);
        } else {
            int sumOfAllLengths = treasureChest.stream().mapToInt(String::length).sum();

            double average = sumOfAllLengths % treasureChest.size();

            System.out.printf(AVERAGE_TREASURE_GAIN, average);
        }
    }
    private static void handleSteal(String[] tokens, List<String> treasureChest) {
        int toBeRemovedFromChest = Integer.parseInt(tokens[1]);

        if (toBeRemovedFromChest > treasureChest.size()) {
            toBeRemovedFromChest = treasureChest.size();
        }

        List<String> removed = new LinkedList<>();
        for (int i = treasureChest.size() - 1; i > toBeRemovedFromChest; i--) {
            String current = treasureChest.get(i);
            removed.add(current);
            treasureChest.remove(current);
        }
        removed.forEach(e -> System.out.printf("%s, ", e));
    }

    private static void handleDrop(String[] tokens, List<String> treasureChest) {
        int indexOfItem = Integer.parseInt(tokens[1]);

        String toBeAddedAtBack = treasureChest.get(indexOfItem);
        treasureChest.remove(indexOfItem);
        treasureChest.addLast(toBeAddedAtBack);
    }

    private static void handleLoot(String[] tokens, List<String> treasureChest) {
        String[] items = tokens[1].split("\\s+");
        for (String currentItem : items) {
            if (!treasureChest.contains(currentItem)) {
                treasureChest.addFirst(currentItem);
            }
        }
    }
}
