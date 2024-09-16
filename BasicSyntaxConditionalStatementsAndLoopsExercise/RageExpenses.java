package BasicSyntaxConditionalStatementsAndLoopsExercise;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lostGamesCount = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());


        int trashedHeadsets = 0;
        int trashedMouses = 0;
        int trashedKeyboard = 0;
        int trashedDisplay = 0;
        for (int i = 1; i <= lostGamesCount; i++) {

            if (i % 2 == 0) {
                trashedHeadsets++;
            }

            if (i % 3 == 0) {
                trashedMouses++;
            }

            if (i % 2 == 0 && i % 3 == 0) {
                trashedHeadsets++;
                trashedMouses++;
                trashedKeyboard++;
                if (trashedKeyboard % 2 == 0) {
                    trashedDisplay++;
                }
            }

        }

        double totalHeadset = trashedHeadsets * headsetPrice;
        double totalMouses = trashedMouses * mousePrice;
        double totalKeyboard = trashedKeyboard * keyboardPrice;
        double totalDisplay = trashedDisplay * displayPrice;
        double total = totalHeadset + totalMouses + totalKeyboard + totalDisplay;
        System.out.println(total);
    }
}
