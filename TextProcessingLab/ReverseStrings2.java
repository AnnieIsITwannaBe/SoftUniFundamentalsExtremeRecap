package TextProcessingLab;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReverseStrings2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, String> words = reverse(input, scanner);

        printOutput(words);
    }

    private static void printOutput(Map<String, String> words) {
        for (Map.Entry<String, String> entrySet : words.entrySet()) {
            System.out.println(entrySet.getKey() + " = " + entrySet.getValue());
        }
    }

    private static Map<String, String> reverse(String input, Scanner scanner) {
        Map<String, String> words = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        while (!input.equals("end")) {
            String toBeReversed = input;


            for (int i = toBeReversed.length() - 1; i > 0; i--) {
                //think more about how this can be achieved
                sb.append(toBeReversed.charAt(i));
            }

            words.put(toBeReversed, sb.toString());

            resetResult(sb);

            input = scanner.nextLine();
        }
        return words;

        //also consult the solution in the textbook and think about what are the flaws of it
    }

    private static void resetResult(StringBuilder sb) {
        sb.setLength(0);
    }
}
