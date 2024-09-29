package ExamPreparation.RandomizedJudge.FinalExamApril2020New;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class EmojiDetector {
    private static final String COOL_THRESHOLD_RESULT_MESSAGE = "Cool threshold: %d";
    private static final String FINAL_RESULT = "%d emojis found in the text. The cool ones are:";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<String, Integer> allEmojisCoolnessRank = extractData(line);

        int coolnessThreshold = getCoolThreshold(line);

        ArrayList<Map.Entry<String, Integer>> coolestEmojis = allEmojisCoolnessRank.entrySet().stream().
                filter(emoji -> emoji.getValue() >= coolnessThreshold).collect(Collectors.toCollection(ArrayList::new));

        System.out.printf(COOL_THRESHOLD_RESULT_MESSAGE, coolnessThreshold);
        System.out.printf(FINAL_RESULT, allEmojisCoolnessRank.size());


        coolestEmojis.forEach(emoji -> System.out.printf("%s\n", emoji.getKey()));
    }

    private static Map<String, Integer> extractData(String line) {
        Map<String, Integer> allEmojisCoolnessRank = new LinkedHashMap<>();
        Pattern patternEmoji = Pattern.compile("([*:]{2})(?<lettersOnly>[A-Z][a-z]){2,}\\1");
        Matcher matcherEmoji = patternEmoji.matcher(line);

        while (matcherEmoji.find()) {
            String fullText = matcherEmoji.group();
            String lettersOnly = matcherEmoji.group("lettersOnly");

            int currentEmojiCoolness = calculateEmojiCoolness(lettersOnly);
            allEmojisCoolnessRank.putIfAbsent(fullText, currentEmojiCoolness);
        }
        return allEmojisCoolnessRank;
    }

    private static int calculateEmojiCoolness(String lettersOnly) {
        char[] charArray = lettersOnly.toCharArray();
        int sum = 0;
        for (char c : charArray) {
            sum += c;

        }
        return sum;
    }

    private static int getCoolThreshold(String line) {
        Pattern patternDigits = Pattern.compile("\\d+");
        Matcher matcherDigits = patternDigits.matcher(line);

        int coolThreshold = 0;
        while (matcherDigits.find()) {
            coolThreshold += Integer.parseInt(matcherDigits.group());
        }
        return coolThreshold;
    }
}
