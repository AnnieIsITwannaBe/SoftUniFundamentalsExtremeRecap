package TextProcessingMoreEx.ExtractPersonalInformationUsingObjectsAndClasses;

import java.util.Scanner;

public class ASCIISumatorAnnieWay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();
        String lastInputThatIsCompletelyUseless = scanner.nextLine();

        //this will give me unicode representative of that char
        int indexStart = first.charAt(0);
        int indexEnd = second.charAt(0);

        int sum = 0;

        for (int i = indexStart + 1; i < indexEnd; i++) {
            sum += i;
        }

        //this is correct, so you probably have to do something with the last input but it doesn't say what exactly
        System.out.println(sum);
    }
}
