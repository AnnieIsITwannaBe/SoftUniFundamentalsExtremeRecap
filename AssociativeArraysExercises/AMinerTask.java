package AssociativeArraysExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


//think about how you're going to handle the situation when the input is both upper and lower case, handle
// the case-insensitivity nature of the programming problem criteria:
//By adding the . toLowerCase() method to the end of the prompt statement,
// the input is automatically converted to all lowercase, despite the user typing in uppercase or lowercase characters.
//this is a good resource to check: https://www.shecodes.io/athena?tag=case-insensitive
//it's not working and I have zero ideas how to make it work

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine().toLowerCase();

        //think about how to do this with a stream api too:
        Map<String, Integer> resourceQuantity = allocateResourceToQuantity(line, scanner);

        filterEvenQuantityResources(resourceQuantity);
    }

    private static void filterEvenQuantityResources(Map<String, Integer> resourceQuantity) {
        for (Map.Entry<String, Integer> entry : resourceQuantity.entrySet()) {
            if (entry.getValue() % 2 == 0) {
                System.out.println(entry.getKey().toLowerCase() + "->" + entry.getValue());
            }
        }
    }

    private static Map<String, Integer> allocateResourceToQuantity(String line, Scanner scanner) {
        Map<String, Integer> resourceQuantity = new LinkedHashMap<>();
        String resource = scanner.nextLine().toLowerCase(); //1
        while (!resource.equals("end".toLowerCase())) {

            //careful: resource да не стане инт на втора итерация и да гръмне
            int quantity = Integer.parseInt(scanner.nextLine().toLowerCase());//2
            if (!resourceQuantity.containsKey(resource.toLowerCase())) {
                resourceQuantity.putIfAbsent(resource, quantity);
            } else {
                Integer currentQuantity = resourceQuantity.get(resource.toLowerCase());
                resourceQuantity.put(resource, currentQuantity + quantity);
            }

            resource = scanner.nextLine().toLowerCase();
        }
        return resourceQuantity;
    }
}
