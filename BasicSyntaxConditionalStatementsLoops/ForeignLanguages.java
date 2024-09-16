package BasicSyntaxConditionalStatementsLoops;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ForeignLanguages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String country = scanner.nextLine();

        Map<String, String> countryLanguage = new HashMap<>();
        countryLanguage.put("England", "English");
        countryLanguage.put("USA", "English");
        countryLanguage.put("Spain", "Spanish");
        countryLanguage.put("Argentina", "Spanish");
        countryLanguage.put("Mexico", "Spanish");

        System.out.println(countryLanguage.getOrDefault(country, "unknown"));
    }
}
