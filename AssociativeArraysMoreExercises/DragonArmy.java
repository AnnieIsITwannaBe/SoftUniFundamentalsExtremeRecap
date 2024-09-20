package AssociativeArraysMoreExercises;

import java.util.*;

public class DragonArmy {
    //List<Dragon> dragons = entry.getValue();
    //
    //            double averageDamage = getAverageDamageOfCurrentDragon(dragons);
    //            double averageHealth = getAverageHealthOfCurrentDragon(dragons);
    //            double averageArmor = getAverageArmorOfCurrentDragon(dragons);
    //
    //            System.out.printf("%s:: (%.2f//%.2f//%.2f)",entry.getKey(), averageDamage, averageHealth, averageArmor);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Type is preserved as in the order of input, but dragons are sorted alphabetically by name
        //For each type, you should also print the average damage, health, and armor of the dragons.
        // For each dragon, print his stats
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Dragon>> dragonsByType = addDragonsToInventory(n, scanner);
        //Type is preserved as in the order of input, but dragons are sorted alphabetically by name. For each type,
        // you should also print the average damage, health, and armor of the dragons.
        // For each dragon, print his stats.

        //seems like my approach is mostly correct
        dragonsByType.forEach((type, dragons) -> {

//            double averageDamage = getAverageDamageOfCurrentDragon(dragons);
//            double averageHealth = getAverageHealthOfCurrentDragon(dragons);
//            double averageArmor = getAverageArmorOfCurrentDragon(dragons);

            double averageDamage = dragons.stream().mapToInt(Dragon::getDamage).average().orElse(0);
            double averageHealth = dragons.stream().mapToInt(Dragon::getHealth).average().orElse(0);
            double averageArmor = dragons.stream().mapToInt(Dragon::getArmor).average().orElse(0);


            System.out.printf("%s:: (%.2f//%.2f//%.2f)%n", type, averageDamage, averageHealth, averageArmor);
            dragons.stream()   //isnt this the right way in which we sort results by name alphabetically?
                    .sorted((d1, d2) -> d1.getName().compareTo(d2.getName())).forEach(System.out::println);

        });
    }

    private static double getAverageArmorOfCurrentDragon(List<Dragon> dragons) {
        double averageSum = 0.0;

        for (Dragon dragon : dragons) {
            averageSum += dragon.getArmor();
        }
        return averageSum % dragons.size();
    }

    private static double getAverageHealthOfCurrentDragon(List<Dragon> dragons) {
        double averageSum = 0.0;
        for (Dragon dragon : dragons) {
            averageSum += dragon.getHealth();
        }
        return averageSum % dragons.size();
    }

    private static double getAverageDamageOfCurrentDragon(List<Dragon> dragons) {
        double damageSum = 0.0;
        for (Dragon dragon : dragons) {
            damageSum += dragon.getDamage();
        }
        return damageSum % dragons.size();
    }

    private static Map<String, List<Dragon>> addDragonsToInventory(int n, Scanner scanner) {
        Map<String, List<Dragon>> dragonsByType = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            //we have handled everything except the case when the value is null here:
            //Correct Handling of Default Values

//int damage = tokens[2].equals("null") ? 45 : Integer.parseInt(tokens[2]);
//int health = tokens[3].equals("null") ? 250 : Integer.parseInt(tokens[3]);
//int armor = tokens[4].equals("null") ? 10 : Integer.parseInt(tokens[4]);


            String type = tokens[0];
            String name = tokens[1];
            int damage = Integer.parseInt(tokens[2]);
            int health = Integer.parseInt(tokens[3]);
            int armor = Integer.parseInt(tokens[4]);

            Dragon dragon = new Dragon(name, damage, health, armor);
            //if it doesn't contain the dragon, add the dragon:
            if (!dragonsByType.containsKey(type)) {
                dragonsByType.put(type, new ArrayList<>());
                dragonsByType.get(type).add(dragon);
            } else {
                //If the same dragon is added a second time, the new stats should overwrite the previous ones.
                // Two dragons are considered equal if they match by both name and type.
                boolean hasMatch = false;
                int matchIndex = 0;
                List<Dragon> currentDragons = dragonsByType.get(type);

                for (int j = 0; j < currentDragons.size(); j++) {
                    if (currentDragons.get(j).getName().equals(name)) {
                        hasMatch = true;
                        matchIndex = j;
                        break;
                    }
                }
                if (hasMatch) {
                    dragonsByType.get(type).set(matchIndex, dragon);
                }
            }
        }
        return dragonsByType;
    }
}

//                List<Dragon> currentDragonList = dragonsByType.get(type);
//                for (Dragon dragonRepresentative : currentDragonList) {
//                    if (dragonRepresentative.getName().equals(name)) {
//                        hasMatch = true;
//                        break;
//
//                    }
//                }

//dragonsByType.entrySet().stream().sorted(entry -> {
//
//            entry.getValue().stream().
//
//            //System.out.printf("%s:: (%.2f//%.2f//%.2f)", entry.getKey(), entry);
//        })

///dragonsByType.forEach((type, dragons) -> {
//
//    double averageDamage = dragons.stream().mapToInt(Dragon::getDamage).average().orElse(0);
//    double averageHealth = dragons.stream().mapToInt(Dragon::getHealth).average().orElse(0);
//    double averageArmor = dragons.stream().mapToInt(Dragon::getArmor).average().orElse(0);
//
//    System.out.printf("%s:: (%.2f/%.2f/%.2f)%n", type, averageDamage, averageHealth, averageArmor);
//
//    // Sort dragons by name alphabetically
//    dragons.sort(Comparator.comparing(Dragon::getName));
//    dragons.forEach(System.out::println);
//
//});
