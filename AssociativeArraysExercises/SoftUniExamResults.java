package AssociativeArraysExercises;

import java.util.*;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //important question for this problem:
        //how do i get the last element that was added to a map
        //apparently there is a lastEntry method, wow, who knew?
        //okay for reals let's go:

        //Peter-Java-84

        Map<Student, List<Integer>> studentScores = processAllResults(scanner);
        printOutput(studentScores);
    }

    private static void printOutput(Map<Student, List<Integer>> studentScores) {
        System.out.println("Results: ");
        //here from the values u just need to get the last element?
        //that is the final score
        //think carefully about how to do that
        for (Map.Entry<Student, List<Integer>> entry : studentScores.entrySet()) {
            System.out.println(entry.getKey());

        }
    }

    private static String getLastEntry(List<?> list) {
        //i hope that this does what i think it does
        return String.valueOf(list.size() - 1);

    }

    private static Map<Student, List<Integer>> processAllResults(Scanner scanner) {
        Map<Student, List<Integer>> studentScores = new LinkedHashMap<>();
        String line = scanner.nextLine();
        while (!line.equals("exam finished")) {
            String[] tokens = line.split("-");
            String name = tokens[0];
            String language = tokens[1];
            int score = Integer.parseInt(tokens[2]);

            //think about how to handle the input difference situation and the removal of the student in question
            //for now just finish it without the ban thing

            Student student = new Student(name, language, score);

            if (!studentScores.containsKey(student)) {
                studentScores.putIfAbsent(student, new ArrayList<>(List.of(score)));
            } else {
                List<Integer> scores = studentScores.get(student);
                updateScores(scores, score);
                studentScores.put(student, scores);
            }

            line = scanner.nextLine();
        }
        return studentScores;
    }

    private static void updateScores(List<Integer> scores, int score) {
        scores.add(score);
    }
}
