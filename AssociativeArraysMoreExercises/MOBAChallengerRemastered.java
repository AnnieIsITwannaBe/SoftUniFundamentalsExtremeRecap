package AssociativeArraysMoreExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MOBAChallengerRemastered {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        Map<String, Map<String, Integer>> playerPool = maintainSeason(line, scanner);

        playerPool.entrySet().stream().sorted((p1, p2) -> {
            int result = Integer.compare(p2.getValue().values().stream().mapToInt(e -> e).sum(),
                    p1.getValue().values().stream().mapToInt(e -> e).sum());

            if (result == 0) {
                result = p1.getKey().compareTo(p2.getKey());
            }
            return result;
        }).forEach(entry -> {
            System.out.printf("%s: %d skill%n", entry.getKey(), entry.getValue().values().stream().mapToInt(e -> e).sum());
            entry.getValue().entrySet().stream().sorted((e1, e2) -> {
                int result = Integer.compare(e2.getValue(), e1.getValue());
                if (result == 0) {
                    result = e1.getKey().compareTo(e2.getKey());
                }
                return result;
            }).forEach(e -> {
                System.out.printf("- %s <::> %d%n", e.getKey(), e.getValue());
            });
        });
    }

    private static Map<String, Map<String, Integer>> maintainSeason(String line, Scanner scanner) {
        Map<String, Map<String, Integer>> playerPool = new LinkedHashMap<>();
        while (!line.equals("Season end")) {
            handlePlayerAssignment(line, playerPool);

            handleBattle(line, playerPool);

            line = scanner.nextLine();
        }
        return playerPool;
    }

    private static void handleBattle(String line, Map<String, Map<String, Integer>> playerPool) {
        if (line.contains("vs")) {
            String[] tokens = line.split("\\s+vs\\s+");
            String playerA = tokens[0];
            String playerB = tokens[1];

            //if they have at least one position that matches the battle will take place:
            boolean hasMatch = false;

            if (playerPool.containsKey(playerA) && playerPool.containsKey(playerB)) {
                for (String position : playerPool.get(playerA).keySet()) {
                    if (playerPool.get(playerB).containsKey(position)) {
                        hasMatch = true;
                        break;
                    }
                }
            }
            //the player with better *total skills* wins, and the other gets denoted:
            if (hasMatch) {
                if (playerPool.get(playerA).values().stream().mapToInt(e -> e).sum() >
                        playerPool.get(playerB).values().stream().mapToInt(e -> e).sum()) {
                    playerPool.remove(playerB);
                } else {
                    if (playerPool.get(playerB).values().stream().mapToInt(e -> e).sum() >
                            playerPool.get(playerA).values().stream().mapToInt(e -> e).sum()) {
                        playerPool.remove(playerA);
                    }
                }
            }
        }
    }

    private static void handlePlayerAssignment(String line, Map<String, Map<String, Integer>> playerPool) {
        if (line.contains("->")) {
            String[] tokens = line.split("\\s+->\\s+");
            String name = tokens[0];
            String position = tokens[1];
            int skill = Integer.parseInt(tokens[2]);

            Map<String, Integer> playerStats = new LinkedHashMap<>();
            playerStats.put(position, skill);

            if (!playerPool.containsKey(name)) {
                playerPool.put(name, playerStats);
            } else {
                if (!playerPool.get(name).containsKey(position)) {
                    playerPool.get(name).put(position, skill);
                } else {
                    if (playerPool.get(name).get(position) < skill) {
                        playerPool.get(name).put(position, skill);
                    }
                }
            }
        }
    }
}

//// //if they both are present
////                //personally i think that this method is flawed, can we identify the flaws
////                // i think that it will go trough all of them at the same time and it will
////                //possibly skip positions that might be matching?
////                //You’re iterating through all positions of playerA and,
////                // for each position, you're iterating through all positions of playerB
//////                if (playerPool.containsKey(playerA) && playerPool.containsKey(playerB)) {
//////                    //and have at least one position in common:
//////                    for (String currentAPosition : playerPool.get(playerA).keySet()) {
//////                        for (String currentBPosition : playerPool.get(playerB).keySet()) {
//////                            if (currentAPosition.equals(currentBPosition)) {
//////                                hasCommon = true;
//////                                break;
//////                            }
//////                        }
//////                    }
//////                }
