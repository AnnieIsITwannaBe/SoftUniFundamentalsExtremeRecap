package ObjectsAndClassesExercises.Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String firstName = tokens[0];
            String lastName = tokens[1];
            double age = Double.parseDouble(tokens[3]);

            Student student = new Student(firstName, lastName, age);
            students.add(student);
        }

        handleOutput(students);
    }

    //think about how you can order then in descending order
    private static void handleOutput(List<Student> students) {
        //   students.stream().map(e -> e.getGrade()).forEach(System.out::println);
    }
}
