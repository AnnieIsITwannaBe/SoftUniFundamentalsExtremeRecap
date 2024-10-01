package TextProcessingMoreEx.ExtractPersonalInformationUsingObjectsAndClasses;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MorseCodeTranslatorOptimized {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split("\\s+");

        Map<String, Character> morseCodeAlphabet = populateAlphabet();

        StringBuilder decoded = new StringBuilder();

      //Handling Spaces Between Words:
      //Currently, the decoded.append(" "); is inside the wrong loop, which causes a space to be added after each Morse code character, rather than after each word.
        //You should append a space between words after processing all symbols for a single word, not after every character.

        for (Map.Entry<String, Character> entry : morseCodeAlphabet.entrySet()) {
            for (String symbol : line) {
                if (morseCodeAlphabet.containsKey(symbol)) {
                    decoded.append(entry.getValue()).append(" ");
                }
            }

        }

        System.out.println(decoded);

    }

    private static Map<String, Character> populateAlphabet() {
        Map<String, Character> morseCodeAlphabet = new LinkedHashMap<>();
        morseCodeAlphabet.put(".-", 'A');
        morseCodeAlphabet.put("-...", 'B');
        morseCodeAlphabet.put("-.-.", 'C');
        morseCodeAlphabet.put("-..", 'D');
        morseCodeAlphabet.put(".", 'E');
        morseCodeAlphabet.put("..-.", 'F');
        morseCodeAlphabet.put("--.", 'G');
        morseCodeAlphabet.put("....", 'H');
        morseCodeAlphabet.put("..", 'I');
        morseCodeAlphabet.put(".---", 'J');
        morseCodeAlphabet.put("-.-", 'K');
        morseCodeAlphabet.put(".-..", 'L');
        morseCodeAlphabet.put("--", 'M');
        morseCodeAlphabet.put("-.", 'N');
        morseCodeAlphabet.put("---", 'O');
        morseCodeAlphabet.put(".--.", 'P');
        morseCodeAlphabet.put("--.-", 'Q');
        morseCodeAlphabet.put(".-.", 'R');
        morseCodeAlphabet.put("...", 'S');
        morseCodeAlphabet.put("-", 'T');
        morseCodeAlphabet.put("..-", 'U');
        morseCodeAlphabet.put("...-", 'V');
        morseCodeAlphabet.put(".--", 'W');
        morseCodeAlphabet.put("-..-", 'X');
        morseCodeAlphabet.put("-.--", 'Y');
        morseCodeAlphabet.put("--..", 'Z');

        return morseCodeAlphabet;
    }

}
