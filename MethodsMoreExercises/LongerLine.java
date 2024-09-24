package MethodsMoreExercises;

import java.util.Scanner;

public class LongerLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());

        double distance = findBiggerDistance(x1, y1, x2, y2);

    }

    private static int findBiggerDistance(int x1, int y1, int x2, int y2) {

        int[] pair1 = {x1, y1};
        int[] pair2 = {x2, y2};
        double first = calculateDistance(pair1);
        double second = calculateDistance(pair2);

        int winnerIndex = 0;
        if (first < second) {
            winnerIndex = 1;
        }

        return winnerIndex;
    }

    private static double calculateDistance(int[] data) {
        return Math.sqrt(data[0] * data[0] + data[1] * data[1]);
    }
}
