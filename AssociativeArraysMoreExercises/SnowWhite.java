package AssociativeArraysMoreExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class SnowWhite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, Map<String, Integer>> dwarfs = sortDwarfsForSnowWhite(line, scanner);

        //When you receive the command "Once upon a time", the input ends.
        // You must order the dwarfs by physics in descending order and then by the total
        //count of dwarfs with the same hat color in descending order.
        //Then you must print them all.

        //first question: how to order map values in descending order?
        //basically sort map by value

//        dwarfs.entrySet().stream().sorted(entry -> {
//            Stream<Map.Entry<String, Integer>> result = entry.getValue().entrySet().stream().sorted((d1, d2) -> {
//                int result2 = Integer.compare(d2.getValue(), d1.getValue());
//
//                return result2;
//            });
//
//            //return result;
//        });


    }

    private static Map<String, Map<String, Integer>> sortDwarfsForSnowWhite(String line, Scanner scanner) {
        Map<String, Map<String, Integer>> dwarfs = new LinkedHashMap<>();
        while (!line.equals("once upon a time")) {
            String[] tokens = line.split("\\s+<:>\\s+");
            String name = tokens[0];
            String hatColor = tokens[1];
            int physics = Integer.parseInt(tokens[2]);

            //dwarfs and associated attributes:
            Map<String, Integer> dwarfStats = new LinkedHashMap<>();
            dwarfStats.put(hatColor, physics);

            //add it if it doesn't exist
            if (!dwarfs.containsKey(name)) {
                dwarfs.put(name, dwarfStats);
            } else {
                Map<String, Integer> alreadyExistingDwarfStat = dwarfs.get(name);

                //if the name exists, but the hat color is different that's 2 different dwarfs
                if (!alreadyExistingDwarfStat.containsKey(hatColor)) {
                    dwarfs.put(name, dwarfStats);
                } else {

                    //if there is the same color hat and name, only update if the skill is greater
                    int physicsPrev = alreadyExistingDwarfStat.get(hatColor);
                    if (physicsPrev < physics) {
                        dwarfs.put(name, dwarfStats);
                    }
                }
            }
            line = scanner.nextLine();
        }

        return dwarfs;
    }
}
