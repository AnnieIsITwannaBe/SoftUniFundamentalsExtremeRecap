package ArraysLab;

import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfWeek = Integer.parseInt(scanner.nextLine());

        String[] daysOfWeek = {"Mon", "Tue", "Wed", "Thu", "Friday", "Sat", "Sun"};

        for (int i = 1; i <= daysOfWeek.length; i++) {
            if (numberOfWeek > 0 && numberOfWeek < daysOfWeek.length) {
                System.out.println(daysOfWeek[numberOfWeek]);
            } else {
                System.out.println("Invalid day!");
            }
        }
    }
}
