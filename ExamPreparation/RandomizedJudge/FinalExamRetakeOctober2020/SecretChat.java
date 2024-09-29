package ExamPreparation.RandomizedJudge.FinalExamRetakeOctober2020;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        String result = " ";

        while (!line.equals("Reveal")) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            switch (command) {
                case "InsertSpace":
                    handleInsertSpace(tokens, line);
                    break;

                case "Reverse":
                    String substring = tokens[1];

                    int startIndex = line.indexOf(substring);
                    String toBeReversed = line.substring(startIndex, startIndex + substring.length() + 1);

                    StringBuilder sb = new StringBuilder(toBeReversed);
                    sb.reverse();

                    String before = line.substring(0, startIndex - 1);
                    String after = line.substring(substring.length());

                    result = before + sb.toString() + after;

                    break;
                case "ChangeAll":
                    break;

            }
            line = scanner.nextLine();
        }
    }

    private static void handleInsertSpace(String[] tokens, String line) {
        String result;
        int index = Integer.parseInt(tokens[1]);
        StringBuilder sb = new StringBuilder(line);
        sb.insert(index, " ");
        result = sb.toString();
    }
}
