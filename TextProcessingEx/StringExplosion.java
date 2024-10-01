package TextProcessingEx;

import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder container = new StringBuilder(scanner.nextLine());

        int strength = 0;

        for (int i = 0; i < container.length(); i++) {
            if (strength > 0 && container.charAt(i) != '>') {
                container.deleteCharAt(i);
                strength--;
                //  i--;
            } else if (container.charAt(i) == '>') {
                strength = Integer.parseInt(String.valueOf(container.charAt(i + 1)));
            }
        }

        System.out.println(container);
    }
}
