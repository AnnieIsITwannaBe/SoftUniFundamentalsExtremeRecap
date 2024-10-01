package TextProcessingEx;

import java.util.Scanner;

public class MultiplyByBigNumberPossiblyRemastered {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String bigNumber = scanner.nextLine();
        int multiplier = Integer.parseInt(scanner.nextLine());
        int remainder = 0;
        StringBuilder container = new StringBuilder();

        //много много интересен подход на тази задача!
        for (int i = bigNumber.length() - 1; i >= 0; i--) {
            int digit = Integer.parseInt(String.valueOf(bigNumber.charAt(i))); // за да не вземе ASCII стойноста
            int product = digit * multiplier + remainder;
            if (i == 0) {
                container.insert(0, product);
            } else {
                int numberToBeAdded = product % 10;
                remainder = product / 10;
                container.insert(0, numberToBeAdded);
            }
        }

        //remove leading zeroes
        while (bigNumber.charAt(0) == '0' && bigNumber.length() > 1) {
            container.deleteCharAt(0);
        }

        System.out.println(container);
    }
}
