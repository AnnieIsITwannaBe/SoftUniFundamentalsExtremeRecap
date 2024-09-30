package ObjectsAndClasses.definingSimpleClasses.Songs.Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentList = new ArrayList<>();

        String line = scanner.nextLine();
        while (!line.equals("end")) {
            String[] tokens = line.split("\\s+");
            String firstName = tokens[0];
            String lastName = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            String homeTown = tokens[3];

            Student student = new Student(firstName, lastName, age, homeTown);
            studentList.add(student);

            line = scanner.nextLine();
        }

        String townTargetStudents = scanner.nextLine();

        List<Student> filtered = getStudentsFromTargetTown(studentList, townTargetStudents);

        printResult(filtered);
    }

    private static void printResult(List<Student> filtered) {
        for (Student student : filtered) {
            System.out.println(student.toString());
        }
    }

    private static List<Student> getStudentsFromTargetTown(List<Student> studentList, String townTargetStudents) {
        List<Student> desiredStudents = new ArrayList<>();
        for (Student currentStudent : studentList) {
            if (currentStudent.getHometown().equals(townTargetStudents)) {
                desiredStudents.add(currentStudent);
            }
        }
        return desiredStudents;
    }
}
