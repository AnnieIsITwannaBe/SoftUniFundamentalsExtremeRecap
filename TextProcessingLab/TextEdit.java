package TextProcessingLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TextEdit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> bannedWords = Arrays.stream(scanner.nextLine().split(", ")).toList();
        String text = scanner.nextLine();

        scanTextForBannedWords(bannedWords, text);
    }

    // i have zero ideas how this is supposed to happen
    //check this article: https://www.baeldung.com/java-remove-replace-string-part
    private static void scanTextForBannedWords(List<String> bannedWords, String text) {
        for (int i = 0; i < bannedWords.size(); i++) {
            if (text.contains(bannedWords.get(0)) || text.contains(bannedWords.get(1))) {

            }

        }
    }
}
