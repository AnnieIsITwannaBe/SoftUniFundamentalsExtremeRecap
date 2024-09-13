package ArraysExercise;

import java.util.*;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] first = scanner.nextLine().split("\\s+");
        String[] second = scanner.nextLine().split("\\s+");

        List<String> common = findCommonElements(first, second);
        printFormat(common);
    }

    private static void printFormat(List<String> common) {
        StringBuilder sb = new StringBuilder();
        sb.append(listToString(common));
        System.out.println(sb.toString());
    }

    private static String listToString(List<String> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : list) {
            stringBuilder.append(s).append(" ");
        }

        return stringBuilder.toString();
    }

    private static List<String> findCommonElements(String[] first, String[] second) {
        List<String> common = new ArrayList<>();
        for (String string : second) {
            for (String s : first) {
                if (s.equals(string)) {
                    common.add(s);
                }
            }
        }
        return common;
    }
}
