package AssociativeArraysMoreExercises.AnnieCameUpWithSomeIdea;

import java.util.*;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        Map<String, List<Student>> studentsResultsPerContest = new LinkedHashMap<>();

        while (!line.equals("no more time")) {
            String[] tokens = line.split("\\s+");
            String username = tokens[0];
            String contest = tokens[1];
            int points = Integer.parseInt(tokens[2]);

            //how to check if the current user is participating in the context
            //i did something and this will definitely work
            //but i'm unsure of its efficiency:
            //keep in mind that one user can participate in many contests
            //how to get individual's users total amount of points not only per
            //contest, but for all the contests?
            //освен в Student да имаме Map<Contest, PointsPerContest> и отделно да
            //имаме totalPoints която ще получим като итерираме през всичките values?
            //опитай се да направиш това като се прибереи
            Student student = new Student(username, contest, points);

            studentsResultsPerContest.putIfAbsent(contest, new ArrayList<>());
            studentsResultsPerContest.get(contest).add(student);
            if (student.getContest().equals(contest) && student.getPoints() < points) {
                student.setPoints(points);
            } else {
                student.setPoints(student.getPoints() + points);
            }

            line = scanner.nextLine();
        }
    }
}
