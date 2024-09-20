package AssociativeArraysLab.StreamApi;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FilterWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //only take the words which length is even;
        String[] words = scanner.nextLine().split("\\s+");

        Arrays.stream(words).filter(word -> word.length() % 2 == 0).forEach(System.out::println);

        //you can do this both ways apparently:
        Object[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(word -> word.length() % 2 == 0).toArray();

    }
}
