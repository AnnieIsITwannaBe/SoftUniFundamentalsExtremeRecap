package AssociativeArraysExercises;

import java.util.*;

public class CompanyUsersRemastered {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        Map<String, List<String>> employeeIdsPerCompany = assignIds(line, scanner);

        handleOutput(employeeIdsPerCompany);

    }

    private static void handleOutput(Map<String, List<String>> employeeIdsPerCompany) {
        employeeIdsPerCompany.forEach((k, v) -> {
            System.out.printf("%s%n", k);
            v.forEach(employeeId -> System.out.printf("-- %s%n", employeeId));
        });
    }

    private static Map<String, List<String>> assignIds(String line, Scanner scanner) {
        Map<String, List<String>> employeeIdsPerCompany = new LinkedHashMap<>();
        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+->\\s+");
            String companyName = tokens[0];
            String employeeId = tokens[1];

            employeeIdsPerCompany.putIfAbsent(companyName, new ArrayList<>());
            boolean alreadyExists = employeeIdsPerCompany.get(companyName).stream().noneMatch(id -> id.equals(employeeId));
            if (alreadyExists) {
                employeeIdsPerCompany.get(companyName).add(employeeId);
            }

            line = scanner.nextLine();
        }
        return employeeIdsPerCompany;
    }
}
