package ExamPreparation.RandomizedJudge.FinalExamRetake15082020;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        String result = handleDecodingCommands(line, scanner);

        System.out.printf("The decrypted message is: %s", result);
    }

    private static String handleDecodingCommands(String line, Scanner scanner) {
        String result = " ";
        while (!line.equals("Decode")) {
            String[] tokens = line.split("\\|");
            String command = tokens[0];

            result = switch (command) {
                case "ChangeAll" -> handleChangeAll(tokens, line);
                case "Move" -> handleMove(tokens, line);
                case "Insert" -> handleInsert(tokens, line);
                default -> result;
            };
            line = scanner.nextLine();
        }
        return result;
    }

    private static String handleChangeAll(String[] tokens, String line) {
        String substring = tokens[1];
        String replacement = tokens[2];
        return line.replaceAll(substring, replacement);
    }

    private static String handleInsert(String[] tokens, String line) {
        int index = Integer.parseInt(tokens[1]);
        String value = tokens[2];

        StringBuilder stringBuilder = new StringBuilder(line);
        stringBuilder.insert(index - 1, value);

        return stringBuilder.toString();
    }

    private static String handleMove(String[] tokens, String line) {
        int numberOfLetters = Integer.parseInt(tokens[1]);
        String toBeAddedToBack = line.substring(0, numberOfLetters + 1);
        String toRemainInFront = line.substring(numberOfLetters + 1);

        return toRemainInFront + toBeAddedToBack;
    }
}
