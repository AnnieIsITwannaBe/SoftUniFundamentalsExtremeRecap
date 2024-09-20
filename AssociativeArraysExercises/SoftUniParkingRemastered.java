package AssociativeArraysExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParkingRemastered {
    private static final String ONLY_ONE_CAR_PER_USER_MESSAGE = "ERROR: Already registered with plate number: %s%n";

    private static final String SUCCESSFUL_REGISTRATION = "%s registered successfully %s %n";

    private static final String SUCCESSFUL_RESIGNATION = "%s unregistered successfully%n";

    public static void main(String[] args) {
        //само тва с допълнителния ред не го разбирам защо така се получава
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());


        Map<String, String> clientsCarId = maintainParkingEntrance(n, scanner);

        handlePrintingOutput(clientsCarId);
    }

    private static void handlePrintingOutput(Map<String, String> clientsCarId) {
        clientsCarId.forEach((k, v) -> System.out.printf("%s => %s%n", k, v));
    }

    private static Map<String, String> maintainParkingEntrance(int n, Scanner scanner) {
        Map<String, String> clientsCarId = new LinkedHashMap<>();
        while (n-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            String name = tokens[1];

            switch (command) {
                case "register":
                    String carId = tokens[2];

                    handleRegistration(clientsCarId, name, carId);
                    break;
                case "unregister":
                    handleResignation(clientsCarId, name);
                    break;
            }
        }
        return clientsCarId;
    }

    private static void handleResignation(Map<String, String> clientsCarId, String name) {
        clientsCarId.remove(name);
        System.out.printf(SUCCESSFUL_RESIGNATION, name);
    }

    private static void handleRegistration(Map<String, String> clientsCarId, String name, String carId) {
        if (!clientsCarId.containsKey(name)) {
            clientsCarId.put(name, carId);
            System.out.printf(SUCCESSFUL_REGISTRATION, name, carId);
        } else {
            System.out.printf(ONLY_ONE_CAR_PER_USER_MESSAGE, carId);
        }
    }
}
