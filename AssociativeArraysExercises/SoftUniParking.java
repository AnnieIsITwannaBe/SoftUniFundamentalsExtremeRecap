package AssociativeArraysExercises;

import java.util.*;


public class SoftUniParking {
    private static final String ERROR_MESSAGE = "The system only support one car per person at the moment";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, String> clientCar = new LinkedHashMap<>();

        processInput(n, scanner, clientCar);

        printOutput(clientCar);
    }

    private static void printOutput(Map<String, String> clientCar) {
        for (Map.Entry<String, String> entry : clientCar.entrySet()) {
            System.out.println(STR."\{entry.getKey()} -> \{entry.getValue()}");
            //this is something from java 21
        }
    }

    private static void processInput(int n, Scanner scanner, Map<String, String> clientCar) {
        while (n-- > 0) {
            String[] line = scanner.nextLine().split("\\s+");
            String command = line[0];
            String name = line[1];
            String car = line[2];


            switch (command) {
                case "register":
                    handleregistration(clientCar, name, car);
                    break;

                case "unregister":
                    handleUnregistration(clientCar, name);
                    break;
            }

        }
    }

    private static void handleUnregistration(Map<String, String> clientCar, String name) {
        clientCar.remove(name);
    }

    private static void handleregistration(Map<String, String> clientCar, String name, String car) {
        if (!clientCar.containsKey(name)) {
            clientCar.putIfAbsent(name, car);
        } else {
            System.out.println(ERROR_MESSAGE);
        }
    }
}
