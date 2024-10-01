package TextProcessingMoreEx.ExtractPersonalInformationUsingObjectsAndClasses;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MorseCodeRemasteredHopefully {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        //here any sequences of white space are removed, so later in the code we cannot detect them
        //and see where the new word starts and the old one ends


        Map<String, Character> morseCodeAlphabet = getMorseCodeAlphabet();

        StringBuilder decoded = new StringBuilder();

        //adequately handling the spacing here mam
        String[] symbols = line.split(" ");
        for (String symbol : symbols) {
            if (!symbol.isEmpty()) {
                Character character = morseCodeAlphabet.get(symbol);
                if (character != null) {
                    decoded.append(character);
                } else {
                    decoded.append(" ");
                }
            }
        }
        System.out.println(decoded);


    }

    private static Map<String, Character> getMorseCodeAlphabet() {
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
