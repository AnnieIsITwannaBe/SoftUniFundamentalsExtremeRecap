package ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[] numberOfPeopleInWagon = new int[n];
        for (int i = 0; i < n; i++) {
            numberOfPeopleInWagon[i] = Integer.parseInt(scanner.nextLine());
        }

        int sum = Arrays.stream(numberOfPeopleInWagon).sum();
        System.out.println(sum);

    }
}
