package ObjectsAndClasses;

import java.util.*;

public class ShuffleCollectionRandomization2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> wordSequence = new ArrayList<>(Arrays.stream(scanner.nextLine().split("\\s+"))
                .toList());

        Collections.shuffle(wordSequence);

        printOutput(wordSequence);
    }

    private static void printOutput(List<String> wordSequence) {
        System.out.println(listToString(wordSequence));
    }

    private static String listToString(List<?> list) {
        StringBuilder sb = new StringBuilder();
        for (Object o : list) {
            sb.append(o);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
