package ArraysExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String[] currentDnaSequence = new String[n];
        List<String[]> listOfSequences = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("Clown them")) {
            currentDnaSequence = input.split("!");
            listOfSequences.add(currentDnaSequence);


            input = scanner.nextLine();
        }
    }
}
