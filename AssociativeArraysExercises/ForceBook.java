package AssociativeArraysExercises;

import java.util.*;
//The force users are struggling to remember which side is the different forceUsers from because they switch them too often. So you are tasked to create a web application to manage their profiles.
//You will receive several input lines in one of the following formats:
//"{force_side} | {force_user}"
//"{force_user} -> {force_side}"
//The "force_user" and "force_side" are strings, containing any character.
//If you receive "force_side | force_user":
//•	If there is no such force user and no such force side -> create a new force side and add the force user to the corresponding side.
//•	Only if there is no such force user in any force side -> add the force user to the corresponding side.
//•	If there is such force user already -> skip the command and continue to the next operation.
//If you receive a "force_user -> force_side":
//•	If there is such force user already -> change their side.

//много забих тука, мисля да го оставя и да се върна
//make a list of all of the mini-problems that you have to solve here
//and like do it

public class ForceBook {
    public static String DUPLICATE_USER_MESSAGE = "A force user cannot exist twice in the same force side";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<String, List<String>> forceSideUsers = new LinkedHashMap<>();

        while (!line.equals("Lumpawaroo")) {
            String[] data = scanner.nextLine().split("\\s+");
            String forceUser = " ";
            String forceSide = " ";

            //check what is a spliterator? maybe later
            switch (data[1]) {
                case "->":
                    handleInputTypeA(data, forceSideUsers);

                    break;
                case "|":
                    forceUser = data[2];
                    forceSide = data[0];
                    //•	If there is such force user already -> change their side.
                    //•	If there is no such force user in any force side -> add the force user to the corresponding force side.
                    //•	If there is no such force user and no such force side -> create new force side and add the force user to the corresponding side.
                    //•	Then you should print on the console: "{force_user} joins the {force_side} side!".

                    if (!forceSideUsers.containsKey(forceSide)) {
                        forceSideUsers.putIfAbsent(forceSide, new ArrayList<>(List.of(forceUser)));
                    } else {
                        boolean isValid = detectPossibleExistenceWithinOtherSides(forceUser, forceSideUsers);
                        if (isValid) {
                            changeForceSide(forceSideUsers, forceSide, forceUser);
                        }
                    }
                    break;
            }
            line = scanner.nextLine();
        }


    }

    //how to get corresponding key to a value?
    //retrieving the key from a specific value within a map:
    //check this out:https://www.baeldung.com/java-map-key-from-value
    //make sure to go through all approaches
    //also check the guide: https://www.baeldung.com/java-hashmap of the map interface to know more about it bro
    //it's cool to know about those things

    private static void changeForceSide(Map<String, List<String>> forceSideUsers, String forceSide, String forceUser) {
        List<List<String>> namesOfAllUsers = new ArrayList<>(forceSideUsers.values());
        for (List<String> namesOfAllUser : namesOfAllUsers) {
            for (String current : namesOfAllUser)
                if (current.equals(forceUser)) {
                    String key = getCorrespondingKeyToTheValue(forceSideUsers, forceUser);
                }
        }
    }

    private static String getCorrespondingKeyToTheValue(Map<String, List<String>> forceSideUsers, String forceUser) {
        return forceSideUsers.entrySet().stream().filter(entry -> forceUser.equals(entry.getValue()))
                .map(Map.Entry::getKey).toString();

    }

    //annie's little internal monologue while solving this problem:
    //how do i get a list of all the key values within a map?
    //https://www.baeldung.com/java-values-keys-arraylists-hashmap
    //this tutorial will teach how to extract key-list or value list:
    //without retaining concern about  their initial key value pair association,
    //disregarding the associations between them elements:
    //keySet() – Get all keys from the map as a Set
    //values() – Return all values as a Collection
    //very helpful resource if u ask me, brother
    //static block
    //to ensure clarity and verification we'll use unit test assertions

    //think about how to iterate trough a list of other lists
    //apparently a list of lists i referred to as a 2d list in java:
    //check this out: https://www.geeksforgeeks.org/how-to-iterate-over-a-2d-list-or-list-of-lists-in-java/
    private static boolean detectPossibleExistenceWithinOtherSides(String forceUser,
                                                                   Map<String, List<String>> forceSideUsers) {
        List<List<String>> namesOfAllUsers = new ArrayList<>(forceSideUsers.values());
        for (List<String> namesOfAllUser : namesOfAllUsers) {
            for (String current : namesOfAllUser)
                if (current.equals(forceUser)) {
                    return false;
                }
        }
        return true;
    }


    private static void handleInputTypeA(String[] data, Map<String, List<String>> forceSideUsers) {
        String forceUser;
        String forceSide;
        forceSide = data[2];
        forceUser = data[0];

        //•	If there is no such force user and no such force side -> create a new force side and add the force user to the corresponding side.
        //•	Only if there is no such force user in any force side -> add the force user to the corresponding side.
        //•	If there is such force user already -> skip the command and continue to the next operation.

        if (!forceSideUsers.containsKey(forceSide)) {
            forceSideUsers.putIfAbsent(forceSide, new ArrayList<>(List.of(forceUser)));
        } else {
            List<String> usersToForceSide = forceSideUsers.get(forceSide);
            boolean isValid = validateUserValidity(usersToForceSide, forceUser);
            if (isValid) {
                updateForceUsers(usersToForceSide, forceUser);
                forceSideUsers.put(forceSide, usersToForceSide);
            } else {
                System.out.println(DUPLICATE_USER_MESSAGE);
            }
        }
    }

    private static void updateForceUsers(List<String> usersToForceSide, String forceUser) {
        usersToForceSide.add(forceUser);
    }

    private static boolean validateUserValidity(List<String> usersToForceSide, String forceUser) {
        for (String s : usersToForceSide) {
            if (s.equals(forceUser)) {
                return false;
            }
        }
        return true;
    }
}

