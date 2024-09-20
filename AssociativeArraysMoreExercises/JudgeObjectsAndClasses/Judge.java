package AssociativeArraysMoreExercises.JudgeObjectsAndClasses;

import AssociativeArraysMoreExercises.JudgeObjectsAndClasses.Student;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //"{username} -> {contest} -> {points}"
        //The constestName and username are strings, the given points will be an integer number.
        // You need to keep track of every contest and individual statistics of every user.
        // You should check if such a contest already exists, and if not, add it, otherwise,
        // check if the current user is participating in the contest,
        // if he is participating take the higher score, otherwise, just add it.
        //Also, you need to keep individual statistics for each user - the total points of all contests.
        //You should end your program when you receive the command "no more time".
        // At that point, you should print each contest in order of input,
        // for each contest print the participants ordered by points in descending order,
        // then ordered by name in ascending order. After that, you should print individual statistics
        // for every participant ordered by total points in descending order, and then by alphabetical order.

        List<Student> studentsData = new LinkedList<>();
        String line = scanner.nextLine();
        while (!line.equals("no more time")) {
            String[] tokens = line.split("=>");
            String username = tokens[0];
            String contest = tokens[1];
            int points = Integer.parseInt(tokens[2]);

            Student student = new Student(username, contest, points);


            line = scanner.nextLine();
        }
    }
}
