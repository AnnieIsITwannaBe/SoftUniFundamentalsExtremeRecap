package BasicSyntaxConditionalStatementsLoops;

import java.time.Month;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MonthPrinter {
    public static void main(String[] args) {
        //it can also be done with a switch statement
        Scanner scanner = new Scanner(System.in);
        int numMonth = Integer.parseInt(scanner.nextLine());

        Map<Integer, String> monthsRepresentedByNumber = new HashMap<>();

        int index = 1;
        for (Month month : Month.values()) {
            String monthName = month.name().toLowerCase();
            monthsRepresentedByNumber.put(index, monthName.substring(0, 1).toUpperCase() + monthName.substring(1));
            index++;
        }

        System.out.println(monthsRepresentedByNumber.getOrDefault(numMonth, "Error!"));
    }
}
