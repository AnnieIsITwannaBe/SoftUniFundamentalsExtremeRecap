package ArraysExercise;

import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] sequence = scanner.nextLine().split("\\s");
        int rotations = Integer.parseInt(scanner.nextLine());


        //check out other ways to do this:
        while (rotations-- > 0) {
            String temp = sequence[0];
            for (int i = 1; i < sequence.length; i++) {
                sequence[i - 1] = sequence[i];
            }
            sequence[sequence.length - 1] = temp;
        }

        printFormat(sequence);
    }

    private static void printFormat(String[] sequence) {
        System.out.println(String.join(",", sequence));
    }
}
