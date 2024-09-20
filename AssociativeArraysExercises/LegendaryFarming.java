package AssociativeArraysExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {

        //You are playing a game, and your goal is to win a legendary item - any legendary item will be good enough. However, it's a tedious process, and it requires quite a bit of farming. The possible items are:
        //•	"Shadowmourne" - requires 250 Shards
        //•	"Valanyr" - requires 250 Fragments
        //•	"Dragonwrath" - requires 250 Motes
        //"Shards", "Fragments", and "Motes" are the key materials 	(case-insensitive), and everything else is junk.
        //"{quantity1} {material1} {quantity2} {material2} … {quantityN} {materialN}"

        //You will be given lines of input in the format:

        Map<String, Integer> resourceQuantity = new LinkedHashMap<>();

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (line.equals("end")) {
            String resource = line.toLowerCase();
            int quantity = Integer.parseInt(scanner.nextLine());

            if (resource.equals("shards") || resource.equals("fragments") || resource.equals("motes")) {
                if (!resourceQuantity.containsKey(resource)) {
                    resourceQuantity.putIfAbsent(resource, quantity);
                } else {
                    Integer currentQuantity = resourceQuantity.get(resource);
                    if (currentQuantity + quantity == 250) {

                    }
                    resourceQuantity.put(resource, currentQuantity + quantity);
                }
            }


            line = scanner.nextLine();

        }

    }
}
