package AssociativeArraysLab;

import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPairs = Integer.parseInt(scanner.nextLine());
        Map<String, List<String>> synonyms = new HashMap<>();

        allocateWordsToSynonyms(numberOfPairs, scanner, synonyms);

        printOutput(synonyms);
    }
    //make sure to check other people's solution too

    private static void printOutput(Map<String, List<String>> synonyms) {
        for (Map.Entry<String, List<String>> entry : synonyms.entrySet()) {
            System.out.println(entry.getKey() + " -> " + listToString(entry.getValue()));
        }
    }

    private static String listToString(List<?> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append(", ");
            }

        }
        return sb.toString();
    }

    private static void allocateWordsToSynonyms(int numberOfPairs, Scanner scanner, Map<String, List<String>> synonyms) {

        for (int i = 0; i < numberOfPairs; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            if (!synonyms.containsKey(word)) {
                synonyms.putIfAbsent(word, new ArrayList<>(List.of(synonym)));
            } else {
                List<String> synonymsList = synonyms.get(word);
                synonymsList.add(synonym);
                synonyms.put(word, synonymsList);
            }
        }
    }
}
