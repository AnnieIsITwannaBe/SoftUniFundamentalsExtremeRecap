package AssociativeArraysExercises;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Map<String, List<String>> courseStudents = handleSignUpProcess(line, scanner);

        if (!courseStudents.isEmpty()) {
            printResult(courseStudents);
        }
    }

    private static void printResult(Map<String, List<String>> courseStudents) {
        for (Map.Entry<String, List<String>> entry : courseStudents.entrySet()) {
            //think about how to handle the list situation;
        }
    }

    private static Map<String, List<String>> handleSignUpProcess(String line, Scanner scanner) {
        Map<String, List<String>> courseStudents = new LinkedHashMap<>();
        while (!line.equals("end")) {
            String[] tokens = line.split(" : ");
            String courseName = tokens[0];
            String student = tokens[1];
            if (!courseStudents.containsKey(courseName)) {
                courseStudents.putIfAbsent(courseName, new ArrayList<>(List.of(student)));
            } else {
                List<String> currentGroup = courseStudents.get(courseName);
                handleStudentAddition(currentGroup, student);
                courseStudents.put(courseName, currentGroup);
            }

            line = scanner.nextLine();
        }
        return courseStudents;
    }

    private static void handleStudentAddition(List<String> currentGroup, String student) {
        currentGroup.add(student);
    }
}
