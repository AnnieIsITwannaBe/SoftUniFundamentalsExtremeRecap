package AssociativeArraysExercises;

import java.util.*;

public class CompanyUsers {
    public static String DUPLICATE_ID_MESSAGE = "You cannot have 2 employees with the same id";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        new LinkedHashMap<>();

        Map<String, List<String>> employeesIdPerCompany = processEmployeedData(line, scanner);
        if (!employeesIdPerCompany.isEmpty()) {
            printResult(employeesIdPerCompany);
            //do it with objects and classes and figure out how to print the result visually both times
        }
    }

    private static void printResult(Map<String, List<String>> employeesIdPerCompany) {
        printResult(employeesIdPerCompany);
    }

    private static Map<String, List<String>> processEmployeedData(String line, Scanner scanner) {
        Map<String, List<String>> employeesIdPerCompany = new LinkedHashMap<>();
        while (!line.equals("end")) {
            String[] tokens = line.split(" -> ");
            String company = tokens[0];
            String employeeId = tokens[1];

            if (!employeesIdPerCompany.containsKey(company)) {
                employeesIdPerCompany.putIfAbsent(company, new ArrayList<>(List.of(employeeId)));
            } else {
                List<String> ids = employeesIdPerCompany.get(company);
                boolean isValid = checkIdValidity(ids, employeeId);
                if (isValid) {
                    updateId(ids, employeeId);
                    employeesIdPerCompany.put(company, ids);
                } else {
                    System.out.println(DUPLICATE_ID_MESSAGE);
                }
            }
            line = scanner.nextLine();
        }
        return employeesIdPerCompany;
    }

    private static void updateId(List<String> ids, String employeeId) {
        ids.add(employeeId);
    }

    private static boolean checkIdValidity(List<String> ids, String employeeId) {
        for (String id : ids) {
            if (employeeId.equals(id)) {
                return false;
            }
        }
        return true;
    }
}
