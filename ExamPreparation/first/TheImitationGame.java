package ExamPreparation.first;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        //•	"Move {number of letters}":
        //o	Moves the first n letters to the back of the string
        //•	"Insert {index} {value}":
        //o	Inserts the given value before the given index in the string
        //•	"ChangeAll {substring} {replacement}":
        //o	Changes all occurrences of the given substring with the replacement text

        String finalResult = handleStringManipulation(line, scanner);
        System.out.println(finalResult);
    }

    //Incorrect Loop Control Variable Usage
    //Issue: The code is reusing the line variable inside the loop
    // to process the commands and reassigns it after each command, which could
    // lead to confusion and unintended side effects.
    // Also, this might cause logical issues when you use the line variable outside its intended scope.
    private static String handleStringManipulation(String line, Scanner scanner) {
        while (!line.equals("decode")) {
            String[] tokens = line.split("\\|");
            String command = tokens[0];

            switch (command) {
                //Potential IndexOutOfBoundsException in "Move" Command
                //Issue: When handling the "Move" command, if the numberOfLetters exceeds the length of the string,
                // it could lead to an IndexOutOfBoundsException.
                //Solution: Add validation to ensure that the number of letters is within a valid range:
                case "Move":
                    int numberOfLetters = Integer.parseInt(tokens[1]);
                    line = handleMove(line, numberOfLetters);
                    break;

                case "Insert":
                    int index = Integer.parseInt(tokens[1]);
                    String value = tokens[2];

                    line = handleInsert(line, index, value);
                    break;
                case "ChangeAll":
                    String substring = tokens[1];
                    String replacement = tokens[2];

                    line = handleChangeAll(line, substring, replacement);
                    break;
            }
            line = scanner.nextLine();
        }

        return line;
    }

    private static String handleChangeAll(String line, String substring, String replacement) {
        return line.replaceAll(substring, replacement);
        //replaceAllUses regular expression yall
        //if u pass a string it will be interpreted a s a regex pattern and our
        //solution is wrong
        //use just the replace method
    }

    private static String handleInsert(String line, int index, String value) {
        StringBuilder stringBuilder = new StringBuilder(line);
        stringBuilder.insert(index, value);

        return stringBuilder.toString();
    }

    private static String handleMove(String line, int numberOfLetters) {
        String toBeAddedToBack = line.substring(0, numberOfLetters);
        String rest = line.substring(numberOfLetters);

        return rest + toBeAddedToBack;
    }

    //Issue: The handleMove method incorrectly slices the string when moving the first n letters to the back. The code String rest = line.substring(numberOfLetters + 1);
    // skips one character too many and may lead to an IndexOutOfBoundsException.
}
