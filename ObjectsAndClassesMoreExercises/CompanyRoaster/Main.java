package ObjectsAndClassesMoreExercises.CompanyRoaster;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Employee> employees = populateEmployeesList(n, scanner);

        List<Department> departments = allocateEmployeesToDepartments(employees);

        findHighestAverageSalaryPerDepartment(departments);


//        Department targetDepartment = findDepartmentWithHighestSalary(employees);
//
//        //break this into a lot of smaller tasks now:
//        //first we need to find all of department's names
//        //add all of the employees per particular departmnet
//        //then sum all of the salaries of all of the employees in the
//        //particular department and then compare all of the other average salaries
//        //and see which one is the biggest


    }

    private static void findHighestAverageSalaryPerDepartment(List<Department> departments) {
        for (int i = 0; i < departments.size(); i++) {


        }
    }

    private static List<Department> allocateEmployeesToDepartments(List<Employee> employees) {
        //variable's names to consider:
        // the name of the department
        Department currentDepartment;
        List<Employee> employeesPerDepartment = new ArrayList<>();
        List<Department> departments = new ArrayList<>();

        for (Employee employee : employees) {
            String departmentName = employee.getDepartmentName();
            employeesPerDepartment.add(employee);

            currentDepartment = new Department(departmentName, employeesPerDepartment);

            if (!departments.contains(currentDepartment)) {
                departments.add(currentDepartment);
            } else {
                currentDepartment.getEmployeesPerDepartment().add(employee);
                //what happened here is that i tried to do set it by set get and then adding but the return
                //variable to the add method is boolean, and I'm unable to
            }
        }

        return departments;
    }

    private static Department findDepartmentWithHighestSalary(List<Employee> employees) {
        Department department;
        List<Employee> employeesPerDepartment = new ArrayList<>();
        double max = Double.MIN_VALUE;
        Employee maxEmployee = null;
        for (Employee employee : employees) {
            if (employee.getSalary() > max) {
                max = employee.getSalary();
                maxEmployee = employee;
                employeesPerDepartment.add(employee);
            }
        }

        assert maxEmployee != null;
        return department = new Department(maxEmployee.getDepartmentName(), employeesPerDepartment);
    }

    private static List<Employee> populateEmployeesList(int n, Scanner scanner) {

        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];

            Employee employee;

            handleEdgeCases(tokens, name, salary, position, department, employees);

            employee = new Employee(name, salary, position, department);
            employees.add(employee);
        }

        return employees;
    }

    private static void handleEdgeCases(String[] tokens, String name, double salary, String position, String department, List<Employee> employees) {
        Employee employee;
        if (tokens.length == 4) {
            char firstSymbol = tokens[4].toCharArray()[0];
            if (Character.isDigit(firstSymbol)) {
                int age = Integer.parseInt(tokens[4]);
                employee = new Employee(name, salary, position, department, age);
                employees.add(employee);
            } else {
                String email = tokens[4];
                employee = new Employee(name, salary, position, department, email);
                employees.add(employee);
            }
        }
    }


}
