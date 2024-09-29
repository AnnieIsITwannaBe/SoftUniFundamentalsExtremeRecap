package ExamPreparation.second;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        Pattern pattern = Pattern.compile("([#|])(?<itemName>[A-Z][a-z]+)\\1(?<expirationDate>\\d{1,2}/\\d{1,2}/\\d{2})\\1(?<calories>\\d+)");

        Matcher matcher = pattern.matcher(line);

        List<Product> products = addToInventory(matcher);
        //Calculate the total calories of all food items and then determine how many days you can last with the food you have. Keep in mind that you need 2000kcal a day.
        //to finish
    }

    private static List<Product> addToInventory(Matcher matcher) throws ParseException {
        List<Product> products = new LinkedList<>();
        while (matcher.find()) {
            //convert String to date:
            //https://www.javatpoint.com/java-string-to-date
            //what is a parse exception?
            String name = matcher.group("itemName");
            String expirationDate = matcher.group("expirationDate");
            Date date = new SimpleDateFormat("dd|MM|yyyy").parse(expirationDate);
            int calories = Integer.parseInt(matcher.group("calories"));

            Product product = new Product(name, date, calories);
            products.add(product);
        }
        return products;
    }
}
