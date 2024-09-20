package AssociativeArraysExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class AMinerTaskRemastered {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> resourceQuantities = allocateResourceToQuantity(scanner);

        //!important mistake to remember: he mistake in the code snippet you've provided is in the usage of the forEach method. When using forEach with a stream of Map.Entry<K, V>,
        // the lambda function should take one parameter (the Map.Entry<K, V> object) and then use it to access the key and value.

        printResult(resourceQuantities);
//%d тези неща се наричат specifier-и

        //https://www.baeldung.com/java-maps-streams
        // here is an additional resource that you can check, having in mind that this can
        //also be solved using bidirectional map structure
        //streams are sequences of elements that can be easily obtained vy a collection
        //and maps have different structure from mapping from keys to values, but
        //that doesnt mean that we cannot use the stream API to process their content

    }

    private static void printResult(Map<String, Integer> resourceQuantities) {
        resourceQuantities.entrySet().stream()
                .filter(entry -> entry.getValue() % 2 == 0)
                .forEach(entry -> System.out.printf("%s -> %d", entry.getKey(), entry.getValue()));
    }

    private static Map<String, Integer> allocateResourceToQuantity(Scanner scanner) {
        Map<String, Integer> resourceQuantities = new LinkedHashMap<>();
        String resource = scanner.nextLine();
        while (!resource.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());

            //here again we fucking removed if else redundant structure:
            resourceQuantities.putIfAbsent(resource, quantity);
            resourceQuantities.put(resource, resourceQuantities.get(resource) + quantity);


            resource = scanner.nextLine();
        }

        return resourceQuantities;
    }
}
