package TextProcessingRemastered;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        //the result is a new string bc strings rae immutable
        Scanner scanner = new Scanner(System.in);
        String[] bannedWords = scanner.nextLine().split("\\s+");
        String text = scanner.nextLine();
        //i just fucking can't wrap mmy head around this
        //https://www.baeldung.com/java-remove-replace-string-part


        //what this does is simply removing the first occurrence of the banned word
        for (String bannedWord : bannedWords) {
            String symbol = getRepeated(bannedWord);

            int matchIndex = text.indexOf(bannedWord);
            while (matchIndex != -1) {
                text = text.replace(bannedWord, symbol);
                matchIndex = text.indexOf(bannedWord);

            }
            //likely stems from the fact that
            //replaceAll() operates on exact matches of the string or pattern you provide.
            //(\\W|$): This part of the pattern matches any non-word character (\\W) or the end of the string ($),
            // ensuring the banned word is replaced even if it’s followed by punctuation.
        }
        System.out.println(text);
    }

    private static String getRepeated(String bannedWord) {
        String replacement = "*";
        return replacement.repeat(bannedWord.length());
    }

    private static String removeWord(String wordToBeRemoved, String text) {
        int removeIndex = text.indexOf(wordToBeRemoved);
        while (removeIndex != -1) {
            String firstPart = text.substring(0, removeIndex);
            String secondPart = text.substring(removeIndex + wordToBeRemoved.length());
            text = firstPart + secondPart;

            removeIndex = text.indexOf(wordToBeRemoved);
            //softuni's replace one's better apparently
        }
        //винаги, когато намерим нещо се връгщаме от начало
        //until remove
        //personalized split

        return text;
    }


}
