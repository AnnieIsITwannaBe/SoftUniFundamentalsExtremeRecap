package ExamPreparation.RandomizedJudge.MidExamRandom;

import java.util.*;
import java.util.stream.Collectors;

public class MUOnline {
    private static int HP = 100;
    private static int BITCOINS = 0;
    private static final int MAX_HP = 100;
    private static Map<Integer, Integer> BITCOINS_PER_ROOM = new LinkedHashMap<>();
    private static boolean SUCCESSFULLY_FINISHED = true;
    private static final String HEALED_WITH_POTION = "You healed for %d hp.";
    private static final String CURRENT_HP_DISPLAY_MESSAGE = "Current health: %d hp.";
    private static final String FOUND_BITCOINS_MESSAGE = "You found %d bitcoins.";
    private static final String YOU_WERE_KILLED_MESSAGE = "You died! Killed by %s.";
    private static final String DISPLAY_BEST_ROOM_SO_FAR = "Best room: %s";
    private static final String MONSTER_WAS_SLAYED = "You slayed %s.";

    private static final String PLAYER_WENT_TROUGH_ALL_ROOMS = "You've made it!\nBitcoins: %d\nHealth: %d\n";

    //how do we define what is the best room so far, is it the room where we found the biggest amount of bitcoins
    //or the room where we healed the most?

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> rooms = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toCollection(ArrayList::new));
        //arrayList::new works, new ArrayList will not because the supplier type is different

        handleRoomScanningProcess(rooms);

        if (SUCCESSFULLY_FINISHED) {
            System.out.printf(PLAYER_WENT_TROUGH_ALL_ROOMS, HP, BITCOINS);
        }
    }
    private static void handleRoomScanningProcess(List<String> rooms) {
        for (int i = 0; i < rooms.size(); i++) {
            String[] currentRoom = rooms.get(i).split("\\s+");
            String command = currentRoom[0];
            int valueNumber = Integer.parseInt(currentRoom[1]);

            switch (command) {
                case "potion":
                    handleHealing(valueNumber);
                    break;

                case "chest":
                    handleTreasureMining(valueNumber, i);
                    break;

                default:
                    handleMonsterFighting(currentRoom);
            }

            //break the loop if the gamer was killed:
            if (!SUCCESSFULLY_FINISHED) {
                break;
            }
        }
    }

    private static void handleMonsterFighting(String[] currentRoom) {
        String monster = currentRoom[0];
        int monsterAttackPower = Integer.parseInt(currentRoom[1]);
        HP -= monsterAttackPower;

        if (HP <= 0) {
            System.out.printf(YOU_WERE_KILLED_MESSAGE, monster);
            SUCCESSFULLY_FINISHED = false;


            OptionalInt biggestChestAmount =
                    BITCOINS_PER_ROOM.keySet().stream().mapToInt(Integer::intValue).max();

            assert biggestChestAmount.isPresent();
            int indexOfRoom = BITCOINS_PER_ROOM.get(biggestChestAmount.getAsInt());
            System.out.printf(DISPLAY_BEST_ROOM_SO_FAR, indexOfRoom);


        } else {
            System.out.printf(MONSTER_WAS_SLAYED, monster);
        }
    }

    private static void handleTreasureMining(int valueNumber, int i) {
        BITCOINS += valueNumber;
        //тук може би по-доброто решение щеше да бъде наобратно да е
        BITCOINS_PER_ROOM.putIfAbsent(valueNumber, i);
        System.out.printf(FOUND_BITCOINS_MESSAGE, BITCOINS);
    }

    private static void handleHealing(int valueNumber) {
        if (HP + valueNumber > MAX_HP) {
            int utilizedAmountOfPotion = MAX_HP - HP;
            HP += utilizedAmountOfPotion;
            System.out.printf(HEALED_WITH_POTION, utilizedAmountOfPotion);
        } else {
            HP += valueNumber;
            System.out.printf(HEALED_WITH_POTION, valueNumber);
        }

        System.out.printf(CURRENT_HP_DISPLAY_MESSAGE, HP);
    }
    //the answer to my brilliant question: do we need to put break on the default of the switch
    //you can read this article" https://www.tutorialspoint.com/java/switch_statement_in_java.htm

    ///It's easy to write it by utilizing for-each loops
    //                        //think about how to do it using stream api
    //                        //this is very obviously a weak point:
    //                        //https://www.geeksforgeeks.org/stream-max-method-java-examples/
}

