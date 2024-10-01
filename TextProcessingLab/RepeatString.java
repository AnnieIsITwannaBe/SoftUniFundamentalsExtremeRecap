package TextProcessingLab;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        String finalResult = " ";
//        for (int i = 0; i < input.length; i++) {
//            String currentWord = input[i];
//            int repetitionRate = currentWord.length();
//            finalResult = repeatWordByCriteria(currentWord, repetitionRate);
//        }


        System.out.println(finalResult);
    }

    private static String repeatWordByCriteria(String currentWord, int repetitionRate) {

        return " " + String.valueOf(currentWord).repeat(Math.max(0, repetitionRate));
        //https://www.geeksforgeeks.org/string-class-repeat-method-in-java-with-examples/

    }
}
