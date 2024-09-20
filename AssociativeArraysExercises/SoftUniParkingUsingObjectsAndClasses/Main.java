package AssociativeArraysExercises.SoftUniParkingUsingObjectsAndClasses;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static String NO_MORE_SPACE = "Currently, we're unable to accept more than one car per client";
    public static String RESIGNATION_MESSAGE = "%s successfully removed from parking";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Client> clients = handleClientsList(n, scanner);

        validateData(clients);

        //TODO: print the successful registration
    }

    private static void validateData(List<Client> clients) {
        if (!clients.isEmpty()) {
            printOutput(clients);
        }
    }

    private static void printOutput(List<Client> clients) {
        System.out.println(listToString(clients));

    }

    private static String listToString(List<?> list) {
        StringBuilder sb = new StringBuilder();
        for (Object o : list) {
            sb.append(o);
        }
        return sb.toString();
    }

    private static List<Client> handleClientsList(int n, Scanner scanner) {
        List<Client> clients = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String command = tokens[0];
            String name = tokens[1];
            String carModel = tokens[2];

            Client client = new Client(name, carModel);

            handleRegistration(command, clients, client);

            handleResignation(command, clients, client, name);
        }
        return clients;
    }

    private static void handleResignation(String command, List<Client> clients, Client client, String name) {
        if (command.equals("unregister") || clients.contains(client)) {
            clients.remove(client);
            //u can remove by index and u can remove by object
            System.out.printf(STR."\{RESIGNATION_MESSAGE}%n", name);
        }
    }

    private static void handleRegistration(String command, List<Client> clients, Client client) {
        if (command.equals("register") && !clients.contains(client)) {
            clients.add(client);
        } else {
            System.out.println(NO_MORE_SPACE);
        }
    }
}
