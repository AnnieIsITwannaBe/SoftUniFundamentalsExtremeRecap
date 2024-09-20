package AssociativeArraysExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsAsStringsRemastered {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");


        Map<Character, Integer> characterOccurrences = countCharacterOccurrences(input);

        //countCharOccurrencesType2(input);

        //now let's use some stream API for this printing, shall we?
        //yes, indeed:
        //как беше сега

        //foreach can be replaced with loop:

        //for (Map.Entry<Character, Integer> entry : characterOccurrences.entrySet()) {
        //            Character v = entry.getKey();
        //            Integer k = entry.getValue();
        //            System.out.printf("%s -> %d", v, k);
        //        }

        characterOccurrences.forEach((v, k) -> System.out.printf("%s -> %d", v, k));


    }

//    private static Map<Character, Integer> countCharOccurrencesType2(String[] input) {
//        Map<Character, Integer> characterOccurrences = new LinkedHashMap<>();
    //this removes te if else structure and makes te code look more clear
//
//        //this is simply another way to put it:
//        for (String word : input) {
//            for (Character ch : word.toCharArray()) {
//                characterOccurrences.putIfAbsent(ch, 1);
//                characterOccurrences.put(ch, characterOccurrences.get(ch) + 1);
//            }
//        }
//        return characterOccurrences;
//    }


    private static Map<Character, Integer> countCharacterOccurrences(String[] input) {
        Map<Character, Integer> charOccurrences = new LinkedHashMap<>();

        for (String word : input) {
            for (Character ch : word.toCharArray()) {
                if (!charOccurrences.containsKey(ch)) {
                    charOccurrences.put(ch, 1);
                } else {
                    Integer currentCount = charOccurrences.get(ch);
                    charOccurrences.put(ch, currentCount + 1);
                }
            }
        }
        return charOccurrences;
    }
}
