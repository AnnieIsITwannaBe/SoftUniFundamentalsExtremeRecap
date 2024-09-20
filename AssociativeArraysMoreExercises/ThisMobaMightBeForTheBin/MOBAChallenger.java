package AssociativeArraysMoreExercises.ThisMobaMightBeForTheBin;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MOBAChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //multiplayer online battle area
        //apparently they can have multiple positions now,
        //now how are we to handle that

        Map<String, Player> playerPool = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while (!line.equals("season end")) {
            String[] tokens = line.split("\\s+->\\s+");
            if (tokens.length == 3) {
                String name = tokens[0];
                String position = tokens[1];
                int skill = Integer.parseInt(tokens[2]);

                Player currentPlayer = new Player(name, position, skill);
                if (!playerPool.containsKey(name)) {
                    playerPool.put(name, currentPlayer);
                } else {
                    updateSkill(currentPlayer, skill);
                }

            } else if (tokens.length == 2) {
                String playerA = tokens[0];
                String playerB = tokens[1];
            }

            line = scanner.nextLine();
        }
    }

    private static void updateSkill(Player currentPlayer, int skill) {
        int skillUpToNow = currentPlayer.getSkill();
        if (skillUpToNow < skill) {
            currentPlayer.setSkill(skill);
        }
    }
}
