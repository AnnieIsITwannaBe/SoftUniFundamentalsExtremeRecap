package ObjectsAndClasses;

import java.util.*;

public class ShuffleCollectionRandomization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> wordsSequence = new ArrayList<>(Arrays.stream(scanner.nextLine().split("\\s+")).toList());

        //when can i do that and when i cannot not, study this subject
        List<String> randomizedWords;

        int range = wordsSequence.size();

        List<Integer> nums = getRandomIndexes(range);

        randomizedWords = handleWordsRandomization(nums, wordsSequence);

        printOutput(randomizedWords);
    }

    private static void printOutput(List<String> randomizedWords) {
        System.out.println(listToString(randomizedWords));
    }

    private static String listToString(List<?> list) {
        StringBuilder sb = new StringBuilder();
        for (Object o : list) {
            sb.append(o);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    private static List<String> handleWordsRandomization(List<Integer> nums, List<String> words) {
        List<String> wordsRandomized = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            wordsRandomized.add(words.get(i));
        }
        return wordsRandomized;
    }

    //another thing to consider, doest the Collection.shuffle thingy actually shuffles stuff.
    //test it?
    //actually we're like super not considerate about this:
    //it is actually so easy: all you needed to was to
    //shuffle the list of words and that was it
    //but why the fuck isnt it getting randomized with them numbers
    private static List<Integer> getRandomIndexes(int range) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= range; i++) {
            nums.add(i);
        }
        Collections.shuffle(nums);

        return nums;
    }
}
