package ExamPreparation.RandomizedJudge.MidExamRandom;

import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        int totalNumberOfLecturesInTheCourse = Integer.parseInt(scanner.nextLine());
        int additionalBonus = Integer.parseInt(scanner.nextLine());


        int totalAttendances = 0;
        for (int i = 0; i < numberOfStudents; i++) {
            totalAttendances += Integer.parseInt(scanner.nextLine());
        }

        int totalBonus = (totalAttendances / totalNumberOfLecturesInTheCourse) * (additionalBonus + 5);
        System.out.println(totalBonus);
    }
}
