package ExamPreparation.RandomizedJudge.finalExamApril2020;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        String line = scanner.nextLine();
        while (!line.equals("Done")) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];


            password = switch (command) {
                case "TakeOdd" -> handleTakeOddIndexes(password, line);
                case "Substitute" -> handleSubstitute(tokens, password);
                case "Cut" -> handleCut(tokens, password);
                default -> password;
            };

            System.out.println(password);
            line = scanner.nextLine();
        }
    }

    private static String handleCut(String[] tokens, String password) {
        String substring = tokens[1];
        String substitute = tokens[2];

        password = password.replace(substring, substitute);
        return password;
    }

    private static String handleSubstitute(String[] tokens, String password) {
        int index = Integer.parseInt(tokens[1]);
        int length = Integer.parseInt(tokens[2]);

        String toBeRemoved = password.substring(index, length + 1);

        boolean contains = password.contains(toBeRemoved);
        if (contains) {
            //but i think that replace will replace all of them? will  it?
            password = password.replace(toBeRemoved, "");
        }
        return password;
    }

    private static String handleTakeOddIndexes(String password, String line) {
        StringBuilder oddIndicesSubstring = new StringBuilder(password);

        char[] charArray = line.toCharArray();

        for (int i = 0; i < charArray.length; i++) {
            if (i % 3 == 0) {
                oddIndicesSubstring.append(charArray[i]);
            }
        }

        password = oddIndicesSubstring.toString();
        return password;
    }
}
