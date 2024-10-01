package TextProcessingMoreEx.ExtractPersonalInformationUsingObjectsAndClasses;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
//Write a program that reads n lines of strings and extracts the name and age of a given person. The name of the person will be between "@" and "|". The person’s age will be between "#" and "*".
//Example: "Hello my name is @Peter| and I am #20* years old."
//For each found name and age print a line in the following format "{name} is {age} years old."

public class ExtractPersonalInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = populateDatabase(n, scanner);

        people.forEach(System.out::println);
    }

    private static List<Person> populateDatabase(int n, Scanner scanner) {
        List<Person> people = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();

            int startIndex = line.indexOf('@');
            int endIndex = line.indexOf('|');

            String name = line.substring(startIndex + 1, endIndex);

            int ageStartIndex = line.indexOf('#');
            int ageEndIndex = line.indexOf('*');

            int age = Integer.parseInt((line.substring(ageStartIndex + 1, ageEndIndex)));

            Person person = new Person(name, age);
            people.add(person);
        }
        return people;
    }
}
