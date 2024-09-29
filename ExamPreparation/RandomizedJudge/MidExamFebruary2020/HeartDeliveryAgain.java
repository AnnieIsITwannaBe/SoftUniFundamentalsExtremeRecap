package ExamPreparation.RandomizedJudge.MidExamFebruary2020;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class HeartDeliveryAgain {
    private static final String HAS_VALENTINE_DAY = "Place %d has Valentine's day.";
    private static final String ALREADY_HAD_VALENTINE_DAY = "Place %d already had Valentine's day.";
    private static final String MISSION_SUCCESSFULLY_COMPLETED = "Mission was successful";
    private static final String MISSION_UNSUCCESSFUL = "Cupid failed";
    private static final String LAST_OUTPUT_MESSAGE = "Cupid's last position was %d.";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> neighbourhood = Arrays.stream(scanner.nextLine().split("@"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayList::new));

        String line = scanner.nextLine();

        Map<Integer, List<Integer>> lastPositionAndModifiedInteger = handleNeighbourhoodValentineFestivities(line, neighbourhood, scanner);
        System.out.println(lastPositionAndModifiedInteger.size());

        handlePrinting(lastPositionAndModifiedInteger, neighbourhood);
    }

    private static void handlePrinting(Map<Integer, List<Integer>> lastPositionAndModifiedInteger, List<Integer> neighbourhood) {
        int lastPositionOfCupid = 0;
        boolean allAreZero = true;
        for (Map.Entry<Integer, List<Integer>> entry : lastPositionAndModifiedInteger.entrySet()) {
            lastPositionOfCupid = entry.getKey();
            List<Integer> neighbourhoodModified = entry.getValue();

            for (int i = 0; i < neighbourhoodModified.size(); i++) {
                if (neighbourhood.get(i) != 0) {
                    allAreZero = false;
                    break;
                }
            }
        }

        System.out.printf(LAST_OUTPUT_MESSAGE, lastPositionOfCupid);

        if (allAreZero) {
            System.out.println(MISSION_SUCCESSFULLY_COMPLETED);
        } else {
            System.out.println(MISSION_UNSUCCESSFUL);
        }
    }

    private static Map<Integer, List<Integer>> handleNeighbourhoodValentineFestivities(String line, List<Integer> neighbourhood, Scanner scanner) {
        int cupidIndex = 0;
        Map<Integer, List<Integer>> singleResult = new LinkedHashMap<>();
        while (!line.equals("Love!")) {
            String[] tokens = line.split("\\s+");
            int distanceToJump = Integer.parseInt(tokens[1]);

            if (neighbourhood.get(distanceToJump) == 0) {
                System.out.printf(ALREADY_HAD_VALENTINE_DAY, distanceToJump);
            }

            //common part can be extracted remove branch
            if (!isWithinNeighbourhood(distanceToJump, neighbourhood)) {
                //if the jump becomes bigger than tge neighbourhood
                distanceToJump = resetDistance();
            }
            cupidVisit(neighbourhood, distanceToJump);
            printCongratsIfTheyReachedZero(neighbourhood, distanceToJump, HAS_VALENTINE_DAY);

            cupidIndex = distanceToJump;

            line = scanner.nextLine();
        }

        singleResult.put(cupidIndex, neighbourhood);

        return singleResult;
    }

    private static void printCongratsIfTheyReachedZero(List<Integer> neighbourhood, int distanceToJump, String hasValentineDay) {
        if (neighbourhood.get(distanceToJump) == 0) {
            System.out.printf(hasValentineDay, distanceToJump);
        }
    }

    private static void cupidVisit(List<Integer> neighbourhood, int distanceToJump) {
        int currentHeartQuantity = neighbourhood.get(distanceToJump);
        int updated = cupidVisitSubtraction(currentHeartQuantity);
        neighbourhood.set(distanceToJump, updated);
    }

    private static int resetDistance() {
        int distanceToJump;
        distanceToJump = 0;
        return distanceToJump;
    }

    private static int cupidVisitSubtraction(int currentHeartQuantity) {
        currentHeartQuantity = currentHeartQuantity - 2;
        return currentHeartQuantity;
    }

    private static boolean isWithinNeighbourhood(int distanceToJump, List<Integer> list) {
        return distanceToJump < list.size();
    }
}
