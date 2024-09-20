package AssociativeArraysExercises;

import java.util.*;

public class StudentsAcademyRemastered2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentsGrades = assignGradesToStudents(n, scanner);

        //fucking nailed it
        studentsGrades.forEach((key, value) -> {
            double averageGrade = value.stream().mapToDouble(x -> x).average().orElse(0.0);
            if (averageGrade >= 4.50) {
                System.out.printf("%s -> %.2f%n", key, averageGrade);
            }
        });
    }

    private static Map<String, List<Double>> assignGradesToStudents(int n, Scanner scanner) {
        Map<String, List<Double>> studentsGrades = new LinkedHashMap<>();
        while (n-- > 0) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());
            studentsGrades.putIfAbsent(name, new ArrayList<>());
            studentsGrades.get(name).add(grade);
        }
        return studentsGrades;
    }
}
