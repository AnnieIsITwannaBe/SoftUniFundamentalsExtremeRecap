package AssociativeArraysExercises;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String studentName = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            Map<String, List<Double>> studentGrade = processStudentInfo(studentName, grade);
            if (!studentGrade.isEmpty()) {
                //that is the only thing you have left to do my dear:
                //also figure out how to find the average of all of the grades
                // this is all u need in order to finish
                //do it with objects and classes
                printResult(studentGrade);
            }
        }
    }

    private static void printResult(Map<String, List<Double>> studentGrade) {
        printResult(studentGrade);
    }

    private static Map<String, List<Double>> processStudentInfo(String studentName, double grade) {
        //consult this with ur precious mind and maybe chat gpt:
        Map<String, List<Double>> studentGrade = new LinkedHashMap<>();
        if (!studentGrade.containsKey(studentName)) {
            studentGrade.putIfAbsent(studentName, new ArrayList<>(List.of(grade)));
        } else {
            List<Double> grades = studentGrade.get(studentName);
            updateGrades(grades, grade);
            studentGrade.put(studentName, grades);
        }

        return studentGrade;
    }

    private static void updateGrades(List<Double> grades, double grade) {
        grades.add(grade);
    }
}
