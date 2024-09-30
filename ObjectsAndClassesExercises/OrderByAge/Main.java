package ObjectsAndClassesExercises.OrderByAge;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        List<Person> people = populatePeopleList(line, scanner);

        orderByAgeOutput(people);
    }

    private static void orderByAgeOutput(List<Person> people) {
        //think about how to use a stream to get the age and order it in increasing order
    }

    private static List<Person> populatePeopleList(String line, Scanner scanner) {
        List<Person> people = new ArrayList<>();
        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");
            String name = tokens[0];
            String id = tokens[1];
            int age = Integer.parseInt(tokens[2]);

            Person person = new Person(name, id, age);
            people.add(person);

            line = scanner.nextLine();
        }
        return people;
    }
}
