package AssociativeArraysExercises;

import java.util.*;

public class SoftUniExamResultsRemastered {
    //non-static method cannot be referenced from a non-static context -> check what this means later
    //check what flatmap does
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<String, List<Integer>> studentsResults = new LinkedHashMap<>();
        Map<String, Integer> submissionPerLanguage = new LinkedHashMap<>();

        handleMainLogic(line, studentsResults, submissionPerLanguage, scanner);
        //what we need to learn how to do is->
        //find the highest value withing a map<String, List<integer>> where the list of
        //integer is the value
        //essential: you have to find the highest value for each particular group independently of the others
        //in order for it to comply with the context of the current problem

        handleOutput(studentsResults);
    }

    private static void handleOutput(Map<String, List<Integer>> studentsResults) {
        System.out.printf("Results: %n");
        studentsResults.forEach((key, values) -> {

            Optional<Integer> maxResult = values.stream().max(Integer::compareTo);

            maxResult.ifPresent(max -> System.out.printf("%s | %d%n", key, max));

        });

        //figure out how not to print the optional part:
        //Results:
        //Peter | Optional[84]
        //George | Optional[84]
        //Katy | Optional[94]
        //The Optional part is appearing because you are directly printing an Optional object.
        // To avoid printing Optional[...] and just print the actual value,
        // you should extract the value from the Optional before printing it.
        // You can do this using Optional.get() or by using Optional.orElse() or Optional.ifPresent()
    }

    private static void handleMainLogic(String line, Map<String, List<Integer>> studentsResults, Map<String, Integer> submissionPerLanguage, Scanner scanner) {
        while (!line.equals("exam finished")) {
            String[] tokens = line.split("-");
            if (tokens.length == 3) {
                String studentName = tokens[0];
                String language = tokens[1];
                int points = Integer.parseInt(tokens[2]);
                updateResults(studentsResults, studentName, points);

                updateSubmissions(submissionPerLanguage, language);

            } else if (tokens.length == 2) {
                String username = tokens[0];
                studentsResults.remove(username);
            }
            line = scanner.nextLine();
        }
    }

    private static void updateResults(Map<String, List<Integer>> studentsResults, String studentName, int points) {
        studentsResults.putIfAbsent(studentName, new ArrayList<>());
        studentsResults.get(studentName).add(points);
    }

    private static void updateSubmissions(Map<String, Integer> submissionPerLanguage, String language) {
        submissionPerLanguage.putIfAbsent(language, 1);
        submissionPerLanguage.putIfAbsent(language, submissionPerLanguage.get(language) + 1);
    }
}
