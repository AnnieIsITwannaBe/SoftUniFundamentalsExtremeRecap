package AssociativeArraysMoreExercises;

import java.util.*;

public class DragonArmyRemastered {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Dragon>> dragonsPerType = addDragonsToInventory(n, scanner);


        dragonsPerType.forEach((type, dragons) -> {
            double averageDamage = dragons.stream().mapToDouble(Dragon::getDamage).average().orElse(0.0);
            double averageHealth = dragons.stream().mapToDouble(Dragon::getHealth).average().orElse(0.0);
            double averageArmor = dragons.stream().mapToDouble(Dragon::getArmor).average().orElse(0.0);

            System.out.printf("%s:: (%.2f/%.2f/%.2f)%n", type, averageDamage, averageHealth, averageArmor);

            for (Dragon dragon : dragons) {
                System.out.println(dragon.toString());
            }


// dragons.sort(Comparator.comparing(Dragon::getName));
//            //s the right way to sort dragons alphabetically by their names.
//            dragons.forEach(System.out::println);
//            //check some stuff about the comparator comparing guy!
        });
    }

    //the problem i identified after debugging is that after each line it processes the same line
    //it never goes to the next, this results in only the first line being processed repeatedly
    //and the others are ignored
    private static Map<String, List<Dragon>> addDragonsToInventory(int n, Scanner scanner) {
        Map<String, List<Dragon>> dragonsPerType = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] tokens = line.split("\\s+");
            //here line remains constant, then we added the: String line = scanner.nextLine(); and now we process all the data
            //causing the method to process only the first line of input n amount of times
            String type = tokens[0];
            String name = tokens[1];
            //health 250, damage 45, and armor 10
            int damage = tokens[2].equals("null") ? 45 : Integer.parseInt(tokens[2]);
            int health = tokens[3].equals("null") ? 255 : Integer.parseInt(tokens[3]);
            int armor = tokens[4].equals("null") ? 10 : Integer.parseInt(tokens[4]);

            Dragon dragon = new Dragon(name, damage, health, armor);

            if (!dragonsPerType.containsKey(type)) {
                dragonsPerType.put(type, new ArrayList<>());
                dragonsPerType.get(type).add(dragon);
            } else {
                //if there is another dragon with the same name and type,
                List<Dragon> currentDragons = dragonsPerType.get(type);
                boolean hasMatch = false;
                int matchIndex = 0;
                for (int j = 0; j < currentDragons.size(); j++) {
                    if (currentDragons.get(j).getName().equals(name)) {
                        matchIndex = j;
                        hasMatch = true;
                        break;
                    }
                }
                if (hasMatch) {
                    dragonsPerType.get(type).set(matchIndex, dragon);
                } else {
                    dragonsPerType.get(type).add(dragon);
                }

            }
        }
        return dragonsPerType;
    }
}
