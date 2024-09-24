package MethodsLaB;

import java.util.Scanner;

public class StringRepeat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int repetition = Integer.parseInt(scanner.nextLine());
        String textAdulterated = repeatString(text, repetition);
        printFormat(textAdulterated);
    }

    private static void printFormat(String textAdulterated) {
        System.out.println(textAdulterated);
    }

    private static String repeatString(String text, int repetition) {
        String updated = " ";
        for (int i = 1; i <= repetition; i++) {
            updated += text;
        }
        //преговори string concatenation in loop

        return updated;
    }
}
