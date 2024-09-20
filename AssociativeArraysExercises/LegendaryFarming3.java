package AssociativeArraysExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //actually нямам представа мамка му, давам нататък

        String[] line = scanner.nextLine().split("//s+");
        int index = 0;

        Map<String, Integer> resourceQuantity = new LinkedHashMap<>();
        resourceQuantity.put(line[0], Integer.parseInt(line[1]));


    }
}
