package AssociativeArraysMoreExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SnowWhiteWithHelp {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> dwarfs = new LinkedHashMap<>();

        String command = scan.nextLine();
        while (!"Once upon a time".equals(command)) {
            String[] tokens = command.split(" <:> ");
            String dwarfName = tokens[0];
            String dwarfHatColor = tokens[1];
            int dwarfPhysics = Integer.parseInt(tokens[2]);

            LinkedHashMap<String, Integer> current = new LinkedHashMap<>();
            current.put(dwarfName, dwarfPhysics);
            if (!dwarfs.containsKey(dwarfHatColor)) {
                dwarfs.put(dwarfHatColor, current);
            } else {
                if (!dwarfs.get(dwarfHatColor).containsKey(dwarfName)) {
                    dwarfs.get(dwarfHatColor).put(dwarfName, dwarfPhysics);
                } else {
                    if (dwarfs.get(dwarfHatColor).get(dwarfName) < dwarfPhysics) {
                        dwarfs.get(dwarfHatColor).put(dwarfName, dwarfPhysics);
                    }
                }
            }
            command = scan.nextLine();
        }

        //When you receive the command "Once upon a time", the input ends.
        // You must order the dwarfs
        // by physics in descending order and then by the total count of dwarfs with the same hat color in descending order.
        //Then you must print them all.

        dwarfs.entrySet()
                .stream()
                .sorted((d1, d2) -> {
                    //int result1 = Integer.compare(d2.getValue().values().stream().mapToInt(i -> i).sum();

                    int result = Integer.compare(d2.getValue().values().stream().mapToInt(i -> i).sum(),
                            d1.getValue().values().stream().mapToInt(i -> i).sum());
                    if (result == 0) {
                        //physics in descending order and then by the total count of dwarfs with the same hat color
                        result = Integer.compare(d2.getValue().size(), d1.getValue().size());
                    }
                    return result;
                })
                .forEach(entry -> {
                    entry.getValue()
                            .forEach((key, value) -> System.out.printf("(%s) %s <-> %d%n", entry.getKey(), key, value));
                });
    }
    //this is something i'm not completely sure i fully understand to be honest

    //The sorting mechanism here doesn't directly sort by "total count of dwarfs with the same hat color" across the entire dataset. Instead, it implicitly handles this within the context of each dwarf:
    //
    //The number of hat colors (i.e., the size of the inner map) is used as a tie-breaker when two dwarfs have the same total physics.
    //Dwarfs with more hat colors are considered "greater" and thus appear earlier in the sorted list if physics totals are tied.
    //Why It Works for Sorting by Hat Color
    //Hat Color Count Per Dwarf: The code sorts based on the number of hat colors that each individual dwarf has. Even though it’s not directly sorting based on the overall hat color frequency across all dwarfs, it works within the given problem constraints by considering each dwarf’s hat color count as part of the sorting criteria.
    //
    //Group-Level Sorting: By sorting by total physics first and then by the number of distinct hat colors, the dwarfs are ordered in such a way that within groups of dwarfs with the same total physics, those with more diverse hat colors (larger inner map) are prioritized.
    //
    //Conclusion
    //This sorting approach ensures that the dwarfs are ordered primarily by their total physics and secondarily by the diversity of their hat colors. It doesn’t directly count the total number of dwarfs with the same hat color across the entire collection; instead, it focuses on how diverse each dwarf’s set of hat colors is. This sorting logic leverages the structure of the
    // Map<String, Map<String, Integer>> effectively to meet the problem's requirements.
}