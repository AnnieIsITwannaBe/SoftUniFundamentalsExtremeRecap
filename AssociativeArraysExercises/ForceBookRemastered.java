package AssociativeArraysExercises;

import java.util.*;

public class ForceBookRemastered {
    private static final String ADDED_USER_TO_SIDE_MESSAGE = "%s joins the %s side!%n";
    private static final String FINAL_MESSAGE_SUMMARY = "Side: %s, Members: %d%n";
    private static final String SIDE_MEMBER = "! %s%n";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        Map<String, List<String>> sideUsers = handleUserInput(line, scanner);

        handlePrintingOutput(sideUsers);
    }

    private static void handlePrintingOutput(Map<String, List<String>> sideUsers) {
        sideUsers.forEach((k, v) -> {
            System.out.printf(FINAL_MESSAGE_SUMMARY, k, v.size());
            v.forEach(user -> System.out.printf(SIDE_MEMBER, user));
        });
    }

    private static Map<String, List<String>> handleUserInput(String line, Scanner scanner) {
        Map<String, List<String>> sideUsers = new LinkedHashMap<>();
        while (!line.equals("Lumpawaroo")) {
            if (line.contains("|")) {
                String[] tokens = line.split("\\s+\\|\\s+");
                String sideName = tokens[0];
                String username = tokens[1];

                sideUsers.putIfAbsent(sideName, new ArrayList<>());

                boolean noneMatch = sideUsers.get(sideName).stream().noneMatch(user -> user.equals(username));

                if (noneMatch) {
                    sideUsers.get(sideName).add(username);

                }
            } else if (line.contains("->")) {
                String[] tokens = line.split("\\s+->\\s+");
                String username = tokens[0];
                String sideName = tokens[1];

                //this is how we go through all the list's username's
                sideUsers.forEach((k, v) -> v.remove(username));
                sideUsers.putIfAbsent(sideName, new ArrayList<>());
                sideUsers.get(sideName).add(username);
                System.out.printf(ADDED_USER_TO_SIDE_MESSAGE, username, sideName);
            }

            line = scanner.nextLine();
        }
        return sideUsers;
    }
}
