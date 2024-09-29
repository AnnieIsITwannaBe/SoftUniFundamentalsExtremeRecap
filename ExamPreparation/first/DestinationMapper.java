package ExamPreparation.first;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    //([=\/])(?<city>[A-Z][a-z]+)\1
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        Pattern pattern = Pattern.compile("([=/])(?<city>[A-Z][a-z]+)\\1");

        Matcher matcher = pattern.matcher(line);

        int sum = 0;
        List<String> validCities = new LinkedList<>();
        while (matcher.find()) {
            String city = matcher.group("city");
            validCities.add(city);
            sum += city.length();
        }

        System.out.println("Destinations:");
        validCities.forEach(city -> System.out.printf("%s,", city));

        System.out.printf("Total points: %d", sum);
    }
}
