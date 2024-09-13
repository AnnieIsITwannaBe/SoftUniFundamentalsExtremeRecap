package ArraysExercise;

import javax.print.DocFlavor;
import java.sql.Array;
import java.util.*;

public class CommonElementsImproved {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] first = scanner.nextLine().split("\\s+");
        String[] second = scanner.nextLine().split("\\s+");

        List<String> commons = findCommonElements(first, second);
        printFormat(commons);
    }

    private static void printFormat(List<String> commons) {
        StringBuilder sb = new StringBuilder();
        sb.append(listToString(commons));
        System.out.println(sb.toString());

    }

    private static String listToString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String string : list) {
            sb.append(string).append(" ");
        }
        return sb.toString();

        //u can also use String.join(" ", list)
        //but this will only work for strings
    }

    private static String listToString2(List<?> list) {
        //When you use a wildcard (?) in the method parameter,
        // it means that the method can accept a List of any type,
        // but you lose the ability to directly use the specific type within the method.
        StringBuilder sb = new StringBuilder();
        for (Object object : list) {
            //Because the specific type is unknown, the elements in the list are treated as Object.
        }
        //Yes, exactly! In Java,
        // Object is the superclass of all other classes.
        // This means every class in Java implicitly extends Object, either directly or indirectly.
        // Consequently, every object in Java can be treated as an instance of Object

        return "mama";
    }

    private static List<String> findCommonElements(String[] first, String[] second) {
        Set<String> firstAsSet = new HashSet<>(Arrays.asList(first));
        List<String> commons = new ArrayList<>();

        for (String string : second) {
            if (firstAsSet.contains(string)) {
                commons.add(string);
            }
        }
        return commons;
    }
}
