package TextProcessingEx;

import java.util.Scanner;

public class ReplaceRepeatingStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder container = new StringBuilder(scanner.nextLine());
        //вариант е и да си ги добавяме в една колекция само различните

        for (int i = 0; i < container.length() - 1; i++) { //до -1 защото, когато съм стигнал предпоследния, вече ще съм проверил и последния
            char current = container.charAt(i);
            char next = container.charAt(i + 1);
            if (current == next) {
                container.deleteCharAt(i);
                i--;
                //защото ние намалявеме размера на стринга тука, а в цикъла продължава да се увеличава
                //в един момент ще излезем от рамките му
                //когато трием намаляме инкрементатора, за да не измезем извън рамките на цикъла
            }
        }
        System.out.println(container);
    }
}
