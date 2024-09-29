package ExamPreparation.RandomizedJudge.MidExam052020;

import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int employeeCapacity1 = Integer.parseInt(scanner.nextLine());
        int employeeCapacity2 = Integer.parseInt(scanner.nextLine());
        int employeeCapacity3 = Integer.parseInt(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());

        int totalStudentsPerHour = employeeCapacity1 + employeeCapacity2 + employeeCapacity3;

        int hours = 0;

        while (studentsCount > 0) {
            studentsCount -= totalStudentsPerHour;
            hours++;
        }

        System.out.printf("Time needed %dh.", hours);
    }
}
