//package AssociativeArraysMoreExercises.начиИтакаНеСтаваПУУУУУУУУУУУ;
//
//import java.util.*;
//
//public class MOBAChallenger {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String line = scanner.nextLine();
//
//        Map<String, Player> playerPool = new LinkedHashMap<>();
//
//        while (!line.equals("end of season")) {
//            String[] tokens = line.split("\\s+->\\s+");
//            if (tokens.length == 3) {
//                String name = tokens[0];
//                String position = tokens[1];
//                int skill = Integer.parseInt(tokens[2]);
//
//                if (!playerPool.containsKey(name)) {
//                    Player player = new Player(name);
//                    player.addOrUpdatePosition(position, skill);
//                    playerPool.put(name, player);
//                } else {
//                    // Update existing player
//                    Player player = playerPool.get(name);
//                    player.addOrUpdatePosition(position, skill);
//                }
//
//            } else if (tokens.length == 2) {
//                String playerA = tokens[0];
//                String playerB = tokens[1];
//
//                //check if both exists within pool
//                if (playerPool.containsKey(playerA) && playerPool.containsKey(playerB)) {
//                    //compare their positions -> they must have at least one in common
//                    if (playerPool.get(playerA).)
//
//                }
//            }
//            line = scanner.nextLine();
//        }
//    }
//}
