package TextProcessingEx;

import java.util.Scanner;

public class CaesarCypher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String textToBeEncrypted = scanner.nextLine();


        //и моето проработи, но виж неготовото пак
        char[] text = textToBeEncrypted.toCharArray();
        for (int i = 0; i < text.length; i++) {
            text[i] = (char) (text[i] + 3);
        }

        for (char c : text) {
            System.out.print(c);
        }
    }
}
