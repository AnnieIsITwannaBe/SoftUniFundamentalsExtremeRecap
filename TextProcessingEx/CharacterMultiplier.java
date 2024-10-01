package TextProcessingEx;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");

        char[] first = input[0].toCharArray();
        char[] second = input[1].toCharArray();

        int max = Math.max(first.length, second.length);
        int min = Math.min(first.length, second.length);

        int sum = 0;
        for (int i = 0; i < max; i++) {
            if (i < min) {
                sum += first[i] * second[i];
            } else {
                if (first.length > second.length) {
                    sum += first[i];
                } else {
                    sum += second[i];
                }
            }
        }

        System.out.println(sum);
    }
}
