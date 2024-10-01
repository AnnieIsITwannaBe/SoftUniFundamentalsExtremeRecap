package TextProcessingMoreEx.ExtractPersonalInformationUsingObjectsAndClasses;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split("\\s+");

        Map<Character, String> morseCodeAlphabet = populateAlphabet();
        StringBuilder decoded = new StringBuilder();
        //Using StringBuilder to accumulate the decoded
        //message is efficient and prevents the creation of multiple string objects.

        decodeMorseCode(morseCodeAlphabet, line, decoded);

        System.out.println(decoded);


    }

    private static void decodeMorseCode(Map<Character, String> morseCodeAlphabet, String[] line, StringBuilder decoded) {
        for (Map.Entry<Character, String> entry : morseCodeAlphabet.entrySet()) {
            for (String symbol : line) {
                if (entry.getValue().equals(symbol)) {
                    decoded.append(entry.getKey());
                }
            }

            decoded.append(" ");
        }
        //The current decodeMorseCode method iterates over the morseCodeAlphabet map for every symbol in the line.
        // This is not efficient because it checks every Morse code letter for every symbol, leading to unnecessary comparisons.
    }

    private static Map<Character, String> populateAlphabet() {

        Map<Character, String> morseCodeAlphabet = new LinkedHashMap<>();
        morseCodeAlphabet.put('A', ".-");
        morseCodeAlphabet.put('B', "-...");
        morseCodeAlphabet.put('C', "-.-.");
        morseCodeAlphabet.put('D', "-..");
        morseCodeAlphabet.put('E', ".");
        morseCodeAlphabet.put('F', "..-.");
        morseCodeAlphabet.put('G', "--.");
        morseCodeAlphabet.put('H', "....");
        morseCodeAlphabet.put('I', "..");
        morseCodeAlphabet.put('J', ".---");
        morseCodeAlphabet.put('K', "-.-");
        morseCodeAlphabet.put('L', ".-..");
        morseCodeAlphabet.put('M', "--");
        morseCodeAlphabet.put('N', "-.");
        morseCodeAlphabet.put('O', "---");
        morseCodeAlphabet.put('P', ".--.");
        morseCodeAlphabet.put('Q', "--.-");
        morseCodeAlphabet.put('R', ".-.");
        morseCodeAlphabet.put('S', "...");
        morseCodeAlphabet.put('T', "-");
        morseCodeAlphabet.put('U', "..-");
        morseCodeAlphabet.put('V', "...-");
        morseCodeAlphabet.put('W', ".--");
        morseCodeAlphabet.put('X', "-..-");
        morseCodeAlphabet.put('Y', "-.--");
        morseCodeAlphabet.put('Z', "--..");

        return morseCodeAlphabet;


    }
}
