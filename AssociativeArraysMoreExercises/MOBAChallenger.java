package AssociativeArraysMoreExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MOBAChallenger {
    //Въпроси, които си зададох по този сложен път:
    //1) Как да update->на Map структура, създадена и инициализирана в обект Player
    //която не се подава директно през конструктора
    //отговорът ми донякъде беше, че трябва да си създадеш метод в този обект,
    //с който да достъпваш структурата и да си я манипулираш

    // 2) Как да итерирам през мап колекциите съдържащи се в два обекта от тип Player
    // така, че да сравня дали key позициите в мапа на единия и на другия няма съвпадащи
    // и ако има съвпадащи как да ги сравним по определението от задачата критерии
    //ако имам съвпадащи, как да запазя самата променлива, която съвпада и да сравня с
    //value-то, което съотвества на тази променлива

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();


        Map<String, Player> playerPool = processInput(line, scanner);
        //you can do this with a map within the map

        //how can i print in the order of addition all the content in the player pool;
        playerPool.forEach((v, k) -> {
        });

    }

    private static Map<String, Player> processInput(String line, Scanner scanner) {
        Map<String, Player> playerPool = new LinkedHashMap<>();
        Map<String, Player> playersPerPositions = new LinkedHashMap<>();

        while (!line.equals("Season end")) {
            String[] tokens = line.split("\\s+->\\s+");

            //maybe if we use the contains method it would be better, try with it next time okay sunshine?
            handlePlayersAssignment(playerPool, tokens, playersPerPositions);

            handleBattle(playerPool, tokens, playersPerPositions);

            line = scanner.nextLine();
        }
        return playerPool;
    }

    private static void handleBattle(Map<String, Player> playerPool, String[] tokens, Map<String, Player> playersPerPositions) {
        if (tokens.length == 2) {
            String a = tokens[0];
            String b = tokens[1];

            if (playerPool.containsKey(a) && playerPool.containsKey(b)) {
                //we need to compare whether both have at least one matching position
                Player playerA = playerPool.get(a);
                Player playerB = playerPool.get(b);

                Map<String, Integer> skillPositionsA = playerA.getSkillPerPosition();
                Map<String, Integer> skillPositionsB = playerB.getSkillPerPosition();

                //once we've identified a matching position between 2 players,
                // we can compare the skill values associated
                //with that position
                //if a matching position is found, retrieve the skill value for that position
                //from both players and compare them

                boolean hasCommon = false;

                //you might want to remove that boolean value bc u don't really need it at this point
                for (String position : skillPositionsA.keySet()) {
                    if (skillPositionsB.containsKey(position)) {
                        Integer skillA = skillPositionsA.get(position);
                        Integer skillB = skillPositionsB.get(position);
                        hasCommon = true;
                        break;
                        //denote, remove the one that has less skill
                        //compare the skill values for the matching position:
                        // we already found a matching position, there is no need to go further
                        //
                        //
                    }
                }

                //why can't i stream through a map

            }
        }
    }

    private static void handlePlayersAssignment(Map<String, Player> playerPool, String[] tokens, Map<String,
            Player> playersPerPositions) {
        if (tokens.length == 3) {
            String name = tokens[0];
            String position = tokens[1];
            int skill = Integer.parseInt(tokens[2]);
            if (!playerPool.containsKey(name)) {
                Player player = new Player(name);
                player.addOrUpdatePosition(position, skill);
                playerPool.put(name, player);
            } else {
                Player player = playerPool.get(name);
                player.addOrUpdatePosition(position, skill);
            }
        }
    }
}
