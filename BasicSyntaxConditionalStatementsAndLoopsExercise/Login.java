package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.text.CollationElementIterator;
import java.util.*;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        char[] usernameCharArray = getChars(username);

        String validPassword = reverseUsername(usernameCharArray);
        String input = scanner.nextLine();
        while (!input.equals(validPassword)) {
            System.out.println("Incorrect password. Try again.");
            input = scanner.nextLine();
        }
        System.out.println("User " + username + " logged in.");


    }

    private static String reverseUsername(char[] usernameCharArray) {
        List<Character> passwordContent = new ArrayList<>();
        for (char c : usernameCharArray) {
            passwordContent.add(c);
        }


        Collections.reverse(passwordContent);

        return listToString(passwordContent);
    }

    private static char[] getChars(String username) {
        return username.toCharArray();
    }

    private static String listToString(List<Character> list) {
        StringBuilder sb = new StringBuilder();
        for (Character character : list) {
            sb.append(character);
        }

        return sb.toString();
    }
}
