package AssociativeArraysMoreExercises.readyToBeJustFinished;

import java.util.*;

public class Judge {
    //много съм приятно изненадана от себе си всъщност
    //браво ани! справяш се чудесно
    public static final String FINAL_MESSAGE = "%s: %d participants:%n";
    public static final String STUDENT_CONTEST_POINTS = "%d. %s <::> %d%n";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        Map<String, List<Student>> participantsPerContest = assignStudentsToContests(line, scanner);

        handleOutput(participantsPerContest);

        //the only thing that is left is to figure out how to handle the individual standings of each student;
        //one way that comes to mind i iterate;
        //we will figure this out, together
    }

    private static void handleOutput(Map<String, List<Student>> participantsPerContest) {
        participantsPerContest.forEach((k, v) -> {
            System.out.printf(FINAL_MESSAGE, k, v.size());

            ////for each contest print the participants ordered by points in descending order, then ordered by name in ascending order
            //                //https://www.baeldung.com/java-stream-ordering -> very valuable resource
            v.sort(Comparator.comparing(Student::getPointPerCurrentContest).reversed()
                    .thenComparing(Student::getUsername));


            //u can either add one on the bottom or start from 1 and then let the loop only go trough the <=size
            for (int i = 0; i < v.size(); i++) {
                //this needs to be edited, so that it starts from 1, not from 0
                Student currentStudent = v.get(i);
                System.out.printf(STUDENT_CONTEST_POINTS, i + 1, currentStudent.getUsername(), currentStudent.getPointPerCurrentContest());
            }
        });
    }

    private static Map<String, List<Student>> assignStudentsToContests(String line, Scanner scanner) {
        Map<String, List<Student>> participantsPerContest = new LinkedHashMap<>();
        while (!line.equals("no more time")) {
            String[] tokens = line.split("\\s+->\\s+");
            String username = tokens[0];
            String contest = tokens[1];
            int points = Integer.parseInt(tokens[2]);

            Student currentStudent = new Student(username, points);
            participantsPerContest.putIfAbsent(contest, new ArrayList<>());

            boolean noneMatch =
                    participantsPerContest.get(contest)
                            .stream().noneMatch(student -> student.getUsername().equals(username));

            if (noneMatch) {
                participantsPerContest.get(contest).add(currentStudent);
            } else {
                Optional<Student> alreadyExistingStudent = participantsPerContest.get(contest)
                        .stream().filter(student -> student.getUsername().equals(username)).findFirst();
                alreadyExistingStudent.ifPresent(student -> {
                    if (student.getPointPerCurrentContest() < points) {
                        student.setPointPerCurrentContest(points);
                    }
                });
            }
            line = scanner.nextLine();
        }
        return participantsPerContest;
    }
}
