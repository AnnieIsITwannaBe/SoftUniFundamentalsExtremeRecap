package MethodsMoreExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());

        List<Integer> pair = getCloserPair(x1, x2, y1, y2);
        printFormat(pair);
    }

    private static void printFormat(List<Integer> pair) {

        System.out.println("(" + listToString(pair) + ")");

    }

    private static String listToString(List<?> list) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (Object o : list) {
            counter++;
            sb.append(o);
            if (counter <= 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    private static List<Integer> getCloserPair(int x1, int x2, int y1, int y2) {
        int first = x1 + y1;
        int second = x2 + y2;

        if (first < second) {
            return List.of(x1, y1);
        } else {
            return List.of(x2, y2);
        }
    }
}
