//package AssociativeArraysMoreExercises;
//
//public class SnowWhiteAgain {Map<String, Map<String, Integer>> dwarfs = new HashMap<>();
//
//// Example dwarf data
//dwarfs.put("Dwarf1", Map.of("Red", 50, "Blue", 30));
//dwarfs.put("Dwarf2", Map.of("Red", 20));
//dwarfs.put("Dwarf3", Map.of("Blue", 60));
//
//    // Step 1: Count how many dwarfs share each hat color
//    Map<String, Integer> hatColorCount = new HashMap<>();
//for (Map<String, Integer> dwarf : dwarfs.values()) {
//        for (String color : dwarf.keySet()) {
//            hatColorCount.put(color, hatColorCount.getOrDefault(color, 0) + 1);
//        }
//    }
//
//// Step 2: Sort the dwarfs
//dwarfs.entrySet()
//        .stream()
//    .sorted((d1, d2) -> {
//        // Compare by total physics
//        int totalPhysicsD1 = d1.getValue().values().stream().mapToInt(Integer::intValue).sum();
//        int totalPhysicsD2 = d2.getValue().values().stream().mapToInt(Integer::intValue).sum();
//
//        int result = Integer.compare(totalPhysicsD2, totalPhysicsD1);
//
//        if (result == 0) {
//            // Tie-breaker: Compare by how many dwarfs share the same hat color
//            int maxD1HatColorCount = d1.getValue().keySet().stream()
//                    .mapToInt(hatColorCount::get)
//                    .max().orElse(0);
//            int maxD2HatColorCount = d2.getValue().keySet().stream()
//                    .mapToInt(hatColorCount::get)
//                    .max().orElse(0);
//            result = Integer.compare(maxD2HatColorCount, maxD1HatColorCount);
//        }
//
//        return result;
//    })
//            .forEach(entry -> {
//        entry.getValue().forEach((key, value) ->
//                System.out.printf("(%s) %s <-> %d%n", entry.getKey(), key, value)
//        );
//    });
//
//}


//Explanation of the Code
//Counting Hat Colors:
//
//We iterate over all dwarfs and count how many dwarfs share each hat color using the hatColorCount map.
//Sorting:
//
//Primary Sort: We first sort by the total physics of each dwarf.
//Tie-Breaker:
//If two dwarfs have the same total physics, we then sort them by the maximum number of dwarfs that share any of their hat colors.
//For example, if Dwarf1 has a "Red" hat and "Red" is the most common color among all dwarfs, Dwarf1 will be prioritized in the case of a tie.
//Printing:
//
//After sorting, the dwarfs are printed in the correct order.
//Why This Works
//Primary Sorting: Ensures that the strongest (most total physics) dwarfs are ranked higher.
//Tie-Breaker by Hat Color Count: Ensures that among equally strong dwarfs, those with a hat color shared by many others (indicating commonality or importance) are ranked higher.
//Summary
//The key to solving the problem lies in understanding that the tie-breaker is based on the overall frequency of each hat color across all dwarfs. By first counting how many dwarfs have each hat color, and then using this count to break ties in the sorting process, we ensure the correct order is achieved.
//
//I hope this clarifies the confusion!
