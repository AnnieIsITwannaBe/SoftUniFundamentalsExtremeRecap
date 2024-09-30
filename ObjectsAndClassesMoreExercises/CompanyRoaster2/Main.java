package ObjectsAndClassesMoreExercises.CompanyRoaster2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Employee employee;
        List<Employee> employeeList = new ArrayList<>();

        //The name, salary, position, and department are mandatory while the rest are optional.

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String department = tokens[2];
            String position = tokens[3];

            //how to check whether this is the last position?

            if (tokens.length == 4) {
                char firstSymbol = tokens[3].toCharArray()[0];
                if (!Character.isDigit(firstSymbol)) {
                    String email = tokens[3];
                    employee = new Employee(name, salary, department, position, email);
                    employeeList.add(employee);

                } else {
                    int age = Integer.parseInt(tokens[3]);
                    employee = new Employee(name, salary, department, position, age);
                    employeeList.add(employee);
                }
            }

            String email = tokens[4];
            int age = Integer.parseInt(tokens[5]);
            employee = new Employee(name, salary, department, position, email, age);
        }
    }
}
