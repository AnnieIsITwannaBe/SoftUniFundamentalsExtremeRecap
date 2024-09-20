package AssociativeArraysExercises;

import java.util.*;

public class StudentAcademyRemastered {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, List<Double>> studentGrades = assignGradesToStudents(n, scanner);

        handleOutput(studentGrades);
    }

    private static void handleOutput(Map<String, List<Double>> studentGrades) {
        studentGrades.entrySet()
                .stream()
                .filter(entry -> entry.getValue()
                        .stream().mapToDouble(x -> x)
                        .average().orElse(0.0) >= 4.50)
                .forEach(entry -> {
                    double averageGrade =
                            entry.getValue().stream().mapToDouble(x -> x).average().orElse(0.0);
                    System.out.printf("%s -> %.2f%n", entry.getKey(), averageGrade);

                });
        //this can be remastered, remaster it please

    }

    private static Map<String, List<Double>> assignGradesToStudents(int n, Scanner scanner) {
        Map<String, List<Double>> studentGrades = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            // is this a good idea of the other way around is safer, test it
            //both ways work the same
            //results are not the same as the og answer idk why

            studentGrades.putIfAbsent(name, new ArrayList<>(List.of(grade)));

            studentGrades.get(name).add(grade);
        }
        return studentGrades;
    }
}
