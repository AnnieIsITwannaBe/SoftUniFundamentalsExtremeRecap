package TextProcessingMoreEx.ExtractPersonalInformationUsingObjectsAndClasses;

import java.util.Map;
import java.util.Scanner;

public class ASCIISumatorSoftUniWay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String first = scanner.nextLine();
//        String second = scanner.nextLine();

        //reading a char from the console:
        char a = scanner.nextLine().charAt(0);
        char b = scanner.nextLine().charAt(0);
        String text = scanner.nextLine();

        int startIndex = (int) Math.min(a, b);
        int endIndex = (int) Math.max(a, b);

        int sum = 0;

        for (int i = 0; i < text.length(); i++) {
            int currentChar = text.charAt(i);
            if (currentChar > startIndex && currentChar < endIndex) {
                sum += currentChar;
            }
        }

        System.out.println(sum);
    }
}
