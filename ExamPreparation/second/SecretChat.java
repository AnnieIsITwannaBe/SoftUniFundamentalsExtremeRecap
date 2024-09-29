package ExamPreparation.second;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        //•	"InsertSpace:|:{index}":
        //o	Inserts a single space at the given index. The given index will always be valid.
        //•	"Reverse:|:{substring}":
        //o	If the message contains the given substring, cut it out, reverse it and add it at the end of the message.
        //o	If not, print "error".
        //o	This operation should replace only the first occurrence of the given substring if there are two or more occurrences.
        //•	"ChangeAll:|:{substring}:|:{replacement}":
        //o	Changes all occurrences of the given substring with the replacement text.

        while (!line.equals("reveal")) {
            String[] tokens = line.split(":\\|:");
            String command = tokens[0];

            switch (command) {

                case "InsertSpace":
                    handleInsertSpace(line, tokens);

                    break;
                case "Reverse":
                    handlereverse(line);
                    break;

                case "ChangeAll":
                    handleChangeAll(tokens, line);

                    break;
            }
            line = scanner.nextLine();
        }
    }

    private static void handleChangeAll(String[] tokens, String line) {
        String substring = tokens[1];
        String replacement = tokens[2];
        line = line.replaceAll(substring, replacement);
    }

    private static void handlereverse(String line) {
        StringBuilder sb = new StringBuilder(line);
        sb.reverse();
        line = sb.toString();
    }

    private static void handleInsertSpace(String line, String[] tokens) {
        StringBuilder sb = new StringBuilder(line);
        int index = Integer.parseInt(tokens[1]);
        sb.insert(index, " ");
        line = sb.toString();
    }
}
