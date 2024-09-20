package AssociativeArraysMoreExercises;

import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        //to be continued! this is not the end
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        Map<String, String> contestPasswords = setPasswordsToContests(line, scanner);

        //. After that, you will receive another type of inputs in the format "{contest}=>{password}=>{username}=>{points}"
        // until you receive "end of submissions". Here is what you need to do:
        //•	Check if the contest is valid (if you received it in the first type of input);
        //•	Check if the password is correct for the given contest;
        //•	Save the user with the contest they take part in (a user can take part in many contests)
        // and the points the user has in the given contest. If you receive the same contest and the same user,
        // update the points only if the new ones are more than the older ones.

        Map<String, List<String>> userContests = new LinkedHashMap<>();
        line = scanner.nextLine();
        while (!line.equals("end of submissions")) {
            String[] tokens = line.split("=>");
            String contest = tokens[0];
            String password = tokens[1];
            String username = tokens[2];
            int points = Integer.parseInt(tokens[3]);

            if (contestPasswords.containsKey(contest)) {
                if (contestPasswords.get(contest).equals(password)) {
                    userContests.putIfAbsent(username, new ArrayList<>());
                    userContests.get(username).add(contest);
                }
            }
            line = scanner.nextLine();
        }

    }

    private static Map<String, String> setPasswordsToContests(String line, Scanner scanner) {
        Map<String, String> contestPasswords = new LinkedHashMap<>();
        while (!line.equals("end of contest")) {
            String[] tokens = line.split(":");
            String contest = tokens[0];
            String password = tokens[1];

            contestPasswords.put(contest, password);
            line = scanner.nextLine();
        }
        return contestPasswords;
    }
}
