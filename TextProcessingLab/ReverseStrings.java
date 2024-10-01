package TextProcessingLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        List<String> reversed = reverseInput(input, scanner);
        printOutput(reversed);
    }

    private static void printOutput(List<String> reversed) {
        String output = listToString(reversed);
        System.out.println(output);
    }

    private static String listToString(List<?> list) {
        StringBuilder sb = new StringBuilder();
        for (Object o : list) {
            sb.append(o);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    private static List<String> reverseInput(String input, Scanner scanner) {
        List<String> reversed = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (!input.equals("end")) {
            String currentWord = input;

            for (int i = currentWord.length() - 1; i > 0; i--) {
                sb.append(currentWord.charAt(i));
            }

            //think about how to clear the result:
            reversed.add(sb.toString());

            sb.setLength(0);
            //https://www.baeldung.com/java-clear-stringbuilder-stringbuffer
            //at home try to use the delete method as well

            input = scanner.nextLine();
        }
        return reversed;
    }
}
