package MoreExerciseLists;

import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Character> nonNumbers = findNonNumbersWithinString(input);

        List<Integer> numbers = findDigitsWithinString(input);

        List<Integer> takeList = handleTakeListCriteria(numbers);
        List<Integer> skipList = handleSkipListCriteria(numbers);


//        while (takeList.size() > takeListIndex || skipList.size() > skipListIndex) {
//            StringBuilder sb = new StringBuilder();
//            int currentIndex = 0;
//            int toSkip = 0;
//            for (Integer charactersToTake : takeList) {
//                for (int i = 0; i < charactersToTake; i++) {
//                    sb.append(nonNumbers.get(i));
//                }
//                takeListIndex++;
//                break;
//            }
//
//            for (Integer charactersToSkip : skipList) {
//                toSkip = charactersToSkip;
//                skipListIndex++;
//                break;
//
//            }
//
//
//        }

        //    List<Character> nonNumbersModified = new ArrayList<>();

//        for (int i = 0; i < nonNumbers.size(); i++) {
//            for (Integer take : takeList) {
//                int charactersToTake = take;
//                for (int j = 0; j < charactersToTake; j++) {
//                    nonNumbersModified.add(nonNumbers.get(j));
//                    continue;
//                }
//            }
//
//        }

    }

    private static List<Integer> handleSkipListCriteria(List<Integer> numbers) {
        List<Integer> oddIndexes = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            if (!(i % 2 == 0)) {
                oddIndexes.add(numbers.get(i));
            }

        }
        return oddIndexes;
    }

    private static List<Integer> handleTakeListCriteria(List<Integer> numbers) {
        List<Integer> evenIndexes = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 == 0) {
                evenIndexes.add(numbers.get(i));
            }
        }
        return evenIndexes;
    }

    private static List<Character> findNonNumbersWithinString(String input) {
        char[] characters = input.toCharArray();
        List<Character> nonNumbers = new ArrayList<>();

        for (Character ch : characters) {
            if (!Character.isDigit(ch)) {
                nonNumbers.add(ch);
            }
        }
        return nonNumbers;
    }

    private static List<Integer> findDigitsWithinString(String input) {
        char[] characters = input.toCharArray();
        List<Integer> numbers = new ArrayList<>();

        for (Character ch : characters) {
            if (Character.isDigit(ch)) {
                numbers.add(Character.getNumericValue(ch));
            }
        }
        return numbers;
    }
}
