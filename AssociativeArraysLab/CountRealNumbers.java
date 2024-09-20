package AssociativeArraysLab;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numberSequence = scanner.nextLine().split("\\s+");

        Map<String, Integer> numberOccurrences = handleNumberAllocation(numberSequence);

        printOutput(numberOccurrences);
    }

    private static void printOutput(Map<String, Integer> numberOccurrences) {
        for (Map.Entry<String, Integer> entry : numberOccurrences.entrySet()) {
            System.out.println(entry.getKey() + "->" + entry.getValue());
        }
    }

    private static Map<String, Integer> handleNumberAllocation(String[] numberSequence) {
        Map<String, Integer> numberOccurrences = new HashMap<>();
        for (String s : numberSequence) {
            if (!numberOccurrences.containsKey(s)) {
                numberOccurrences.putIfAbsent(s, 1);
            } else {
                numberOccurrences.put(s, numberOccurrences.get(s) + 1);
            }

            //how tf am i to get досегашния? nvm literally two seconds after i discovered the knowledge within me
            //just like a budhist monk, damn those meditations are definitely working
        }
        return numberOccurrences;
    }
}
