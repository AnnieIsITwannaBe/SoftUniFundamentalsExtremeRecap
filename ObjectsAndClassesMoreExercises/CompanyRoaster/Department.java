package ObjectsAndClassesMoreExercises.CompanyRoaster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    String name;
    List<Employee> employeesPerDepartment;


    public Department(String name, List<Employee> employees) {
        this.name = name;
        this.employeesPerDepartment = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployeesPerDepartment() {
        return employeesPerDepartment;
    }

    public void setEmployeesPerDepartment(List<Employee> employeesPerDepartment) {
        this.employeesPerDepartment = employeesPerDepartment;
    }


}
