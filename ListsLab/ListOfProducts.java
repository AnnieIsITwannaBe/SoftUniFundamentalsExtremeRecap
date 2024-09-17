package ListsLab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOfProducts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> products = processUserInput(n, scanner);
        printFormat(products);
    }

    private static void printFormat(List<String> products) {
        StringBuilder sb = new StringBuilder();
        sb.append(listToString(products));

        System.out.println(sb.toString());

    }

    private static String listToString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        int index = 1;
        for (String product : list) {
            sb.append(index).append(".").append(product);
            sb.append(System.lineSeparator());
            index++;
        }


        return sb.toString();
    }

    private static List<String> processUserInput(int n, Scanner scanner) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String product = scanner.nextLine();
            list.add(product);

        }
        return list;
    }
}
