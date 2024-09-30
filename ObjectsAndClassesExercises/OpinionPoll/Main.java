package ObjectsAndClassesExercises.OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);
            people.add(person);
        }

        List<Person> filtered = filterUnderCriteria(people);

        printOutput(filtered);
    }

    private static void printOutput(List<Person> filtered) {
        //this is one of the approaches:
        filtered.forEach(System.out::println);
        //this will call the toString method from the object's class

        //another approach is using the collectors joining:
        String output = filtered.stream().map(Object::toString).collect(Collectors.joining());
    }

//    private String listToString(List<?> list){
//        StringBuilder sb = new StringBuilder();
//        for(Object o : list){
//            sb.append(o);
//        }
//    }

    private static List<Person> filterUnderCriteria(List<Person> people) {
        List<Person> filtered = new ArrayList<>();

        for (Person person : people) {
            if (person.getAge() >= 30) {
                filtered.add(person);
            }
        }
        return filtered;
    }
}
