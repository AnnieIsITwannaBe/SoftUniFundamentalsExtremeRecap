package ExamPreparation.RandomizedJudge.MidExam052020;

import java.util.Arrays;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Write a program to read a sequence of integers and find and print
        // the top 5 numbers greater than the average value in the sequence, sorted in descending order.

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        int average = sum / numbers.length;

        int[] topBiggerThanAverage = extractWinners(numbers, average);

        //todo: print collection:

        for (int j : topBiggerThanAverage) {
            if (j != 0) {
                System.out.print(j);
            }
        }
    }

    private static int[] extractWinners(int[] numbers, int average) {
        int[] topBiggerThanAverage = new int[5];
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > average) {
                topBiggerThanAverage[i] = numbers[i];
            }
        }
        return topBiggerThanAverage;
    }
}
