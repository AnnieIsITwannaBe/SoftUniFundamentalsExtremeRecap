package TextProcessingEx;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidUsernames {
    //hyphon -> къса хоризонтална чертица
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] usernames = scanner.nextLine().split(",\\s+");
        //([A-Za-z0-9-]+):
        //https://www.geeksforgeeks.org/regular-expressions-in-java/
        //you have to touch some of this

        List<String> validCandidates = validateData(usernames);

        handleOutput(validCandidates);

    }

    private static void handleOutput(List<String> validCandidates) {
        validCandidates.forEach(System.out::println);
    }

    private static List<String> validateData(String[] usernames) {
        List<String> validCandidates = new LinkedList<>();
        for (String userName : usernames) {
            //just fix the size then
            if (Pattern.matches(("[A-Za-z0-9-]+"), userName)
                    && userName.length() >= 3
                    && userName.length() <= 16) {
                validCandidates.add(userName);
            }
        }
        return validCandidates;
    }
}
