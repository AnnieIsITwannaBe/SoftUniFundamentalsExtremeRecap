package AssociativeArraysExercises;

import java.util.*;

public class CoursesRemastered {
    private static final String FINAL_OUTPUT = "%s: %d%n";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        Map<String, List<String>> studentsPerClass = assignStudentsToClasses(line, scanner);

        handleFinalOutput(studentsPerClass);
    }

    private static void handleFinalOutput(Map<String, List<String>> studentsPerClass) {
        studentsPerClass.forEach((k, v) -> {
            System.out.printf(FINAL_OUTPUT, k, v.size());
            v.forEach(student -> System.out.printf("-- %s%n", student));
        });
    }

    private static Map<String, List<String>> assignStudentsToClasses(String line, Scanner scanner) {
        Map<String, List<String>> studentsPerClass = new LinkedHashMap<>();
        while (!line.equals("end")) {
            String[] tokens = line.split("\\s+:\\s+");
            String courseName = tokens[0];
            String studentName = tokens[1];

            studentsPerClass.putIfAbsent(courseName, new ArrayList<>());
            boolean noneMatch = studentsPerClass.get(courseName).stream().noneMatch(student -> student.equals(studentName));
            if (noneMatch) {
                studentsPerClass.get(courseName).add(studentName);
            }
            line = scanner.nextLine();
        }
        return studentsPerClass;
    }
}
