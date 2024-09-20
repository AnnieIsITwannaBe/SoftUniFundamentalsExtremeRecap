package AssociativeArraysExercises.CoursesUsingObjectsAndClasses;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<String, List<Student>> courseStudents = new LinkedHashMap<>();

        handleClassSignUp(line, courseStudents, scanner);
    }

    private static void handleClassSignUp(String line, Map<String, List<Student>> courseStudents, Scanner scanner) {
        while (!line.equals("end")) {
            String[] tokens = line.split(" : ");
            String course = tokens[0];
            String[] fullName = tokens[1].split("\\s+");
            String fistName = fullName[0];
            String secondName = fullName[1];

            Student student = new Student(fistName, secondName);
            if (!courseStudents.containsKey(course)) {
                courseStudents.putIfAbsent(course, new ArrayList<>(List.of(student)));
            } else {
                List<Student> currentStudents = courseStudents.get(course);
                List<Student> newClass = addNewStudent(currentStudents, student);
                courseStudents.put(course, newClass);
            }

            line = scanner.nextLine();
        }
    }

    private static List<Student> addNewStudent(List<Student> currentStudents, Student student) {
        currentStudents.add(student);
        return currentStudents;
    }
}
