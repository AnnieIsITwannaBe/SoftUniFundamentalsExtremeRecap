package TextProcessingLab;

import java.util.Scanner;

public class Substring {
    //TODO: remove all of the occurrences of the first string from the second
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String first = scanner.nextLine();
        String second = scanner.nextLine();

        String modified = second.replaceAll(first, "");
        System.out.println(modified);
    }

    //•	Read the input.
    //•	Find the first index where the key appears.
    //o	Use the built-in method indexOf()
    //•	Remove the match.
    //o	Use the built-in method replace(String oldValue, String newValue)
    //•	Repeat it until the text doesn't contain the key anymore.
}
