package TextProcessingEx;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split("\\s+");
        double sum = 0.0;

        sum = getSum(line, sum);
        System.out.println(sum);
    }

    private static double getSum(String[] line, double sum) {
        for (String word : line) {
            char letterBefore = word.charAt(0);
            char letterAfter = word.charAt(word.length() - 1);
            String number = word.substring(1, word.length() - 1);
            double numberAsDouble = Double.parseDouble(number);

            //•	If it's uppercase you divide the number by the letter's position in the alphabet.
            //•	If it's lowercase you multiply the number with the letter's position in the alphabet
            sum = handleUpperCase(sum, letterBefore, numberAsDouble);

            //Then you move to the letter after the number.
            //•	If it's uppercase you subtract its position from the resulted number.
            //•	If it's lowercase you add its position to the resulted number
            sum = handleLowerCase(sum, letterAfter, numberAsDouble);
        }
        return sum;
    }

    private static double handleLowerCase(double sum, char letterAfter, double numberAsDouble) {
        if (Character.isUpperCase(letterAfter)) {
            sum += numberAsDouble - getLetterPosition(letterAfter);
        } else {
            sum += numberAsDouble + getLetterPosition(letterAfter);
        }
        return sum;
    }

    private static double handleUpperCase(double sum, char letterBefore, double numberAsDouble) {
        if (Character.isUpperCase(letterBefore)) {
            sum += numberAsDouble / getLetterPosition(letterBefore);
        } else {
            sum += numberAsDouble * getLetterPosition(letterBefore);
        }
        return sum;
    }

    private static double getLetterPosition(char letterBefore) {
        return Character.toLowerCase(letterBefore) - 96;
    }
}
