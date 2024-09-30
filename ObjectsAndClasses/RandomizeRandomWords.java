package ObjectsAndClasses;

import java.io.LineNumberInputStream;
import java.util.*;
import java.util.stream.Collectors;

public class RandomizeRandomWords {
    public static void main(String[] args) {
        //problem to consider: by default the random class does not ensure uniqueness of the random
        //generated numbers, delve into how you can ensure uniqueness
        //check the collection.shuffle thingy, check the set-based approach and the shuffle approach


        //upon further investigation this might also not be a good approach
        //simply because the indexes of the list will move with one to the left
        //once deleted and this will cause difficulty selecting the next
        // so we shouldn't remove anything from the original list,
        //simply add the found word at the random index to the shuffled counterpart
        //and ensure uniqueness of the indexes produced by the random class
        //duplicate values cannot be stored in the set, the order is unordered

        Scanner scanner = new Scanner(System.in);
        List<String> words = new ArrayList<>(Arrays.stream(scanner.nextLine().split("\\s+")).toList());
        List<String> wordsRandomized = new ArrayList<>();

        // getCorrespondingRandomIndexes(words, wordsRandomized);

        Set<Integer> randomIndexes = getCorrespondingRandomIndexes(words, wordsRandomized);

        wordsRandomized = handleRandomization(randomIndexes, words);

        printOutput(wordsRandomized);

    }

    private static List<String> handleRandomization(Set<Integer> randomIndexes, List<String> words) {
        List<String> randomWords = new ArrayList<>();
        for (int i = 0; i < randomIndexes.size(); i++) {
            randomWords.add(words.get(i));
        }

        return randomWords;
    }

    private static Set<Integer> getCorrespondingRandomIndexes(List<String> words, List<String> wordsRandomized) {
        Set<Integer> randomIndexes = new HashSet<>();
        Random random = new Random();
        //maybe that is where the problem is
        //because we iterate through the loop, and then we add additional one to the size
        //due it's exclusive last element nature? no, tried adding 1 to the equation-> issue persists
        //it's not randomizing and even the last element is missing
        for (int i = 0; i < words.size() + 1; i++) {
            randomIndexes.add(random.nextInt(words.size() + 1));
        }
        return randomIndexes;
    }

    private static String listToString(List<?> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object o : list) {
            stringBuilder.append(o);
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

    private static void printOutput(List<String> wordsRandomized) {
        System.out.println(listToString(wordsRandomized));
    }

//    private static void getCorrespondingRandomIndexes(List<String> words, List<String> wordsRandomized) {
//        Random random = new Random();
//        for (int i = 0; i < words.size(); i++) {
//            //   Set<Integer> randomIndexes = new LinkedHashSet<>();
//            int currentRandomIndex = random.nextInt(words.size() + 1);
//            if (currentRandomIndex <= words.size()) {
//                wordsRandomized.add(words.get(currentRandomIndex));
//            }
//            //  randomIndexes.add(currentRandomIndex);
//        }

}

